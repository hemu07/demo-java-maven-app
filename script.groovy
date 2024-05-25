def incrementVersion() {
    echo "incrementing app version..."
    sh "mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    def version = matcher[0][1]
    env.IMAGE_NAME = "${version}-${BUILD_NUMBER}"
}
def buildJarFile() {
    echo "Building the application..."  
    sh 'mvn clean package'
}

def buildImage() {
    echo "building the dockerimage.."
                    withCredentials([ 
                        usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'USER', passwordVariable: 'PAT')
                    ]) { 
                        sh "docker build -t hemu07/hemali_repo:${IMAGE_NAME} ."
                        sh "echo ${PAT} | docker login -u ${USER} --password-stdin"
                        sh "docker push hemu07/hemali_repo:${IMAGE_NAME}"
    }
}


def deployApp() {
    echo "Deploying the application..."
}

return this
