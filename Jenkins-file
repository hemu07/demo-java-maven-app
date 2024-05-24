pipeline {
    agent any
    tools {
        maven 'maven-3.9.6'
    }

    stages {
        stage('build jar') {
            steps {
                script {
                    echo "building the app.."
                    sh "mvn package"
                }
            }
        }
        stage('build docker image') {
            steps {
                script {
                    echo "building the dockerimage.."
                    withCredentials([ 
                        usernamePassword(credentials: 'docker-hub-creds', usernameVariable: 'USER', passwordVariable: 'PAT')
                    ]) { 
                        sh "docker build -t hemu07/hemali_repo:jma-1.0 ."
                        sh "echo ${PAT} | docker login -u ${USER} --password-stdin"
                        sh "docker push hemu07/hemali_repo:jma-1.0"
                    }
                }
            }
        }
        stage('deploying the app') {
            steps {
                script {
                    echo "deploying the app.."
                }
            }
        }   
    }
}
