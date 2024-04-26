pipeline {
    agent any 
    tools {
        maven 'maven-3.9.6'
    }
    stages {
        stage ("build jar") {
            steps {
                script {
                    echo "building the app.."
                    sh 'mvn package'
                }
            }
        }
        stage ("build image") {
            steps {
                script {
                    echo "building the docker image.."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh 'docker build -t hemu07/hemali_repo:jma-3.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push hemu07/hemali_repo:jma-3.0'
                    }
                }
            }
        }
        stage ("deploy") {
            steps {
                script {
                    def dockerCmd = 'docker run -p 8080:8080 -d hemu07/hemali_repo:jma-3.0'
                    sshagent(['ec2-ssh-connect']) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@52.90.165.155 ${dockerCmd}"
                    }
                    echo "deploying the app.. on ec2 server "
                }
            }
        }
    }
}
