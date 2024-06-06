#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('build app') {
            steps {
                script {
                    echo "building the app"
                }
            }
        }

        stage ('build image') {
            steps {
                script {
                    echo "building the image"
                }
            }
        }

        stage ('deploy app on k8s') {
            environment {
                AWS_ACCESS_KEY_ID = credentials('jenkins_aws_access_key_id')
                AWS_ACCESS_SECRET_KEY_ID = credentials('jenkins_aws_secret_access_key')
            }
            steps {
                script {
                    echo "deploying the image"
                    sh 'kubectl create deploy nginx-deploy --image=nginx'
                }
            }
        }
    }
}
