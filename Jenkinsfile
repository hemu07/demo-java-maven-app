
def gv
pipeline {
    agent any
  
    tools {
        maven 'maven-3.9.6'
    }

    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build jar') {
            steps {
                script {
                    gv.buildJarFile()
                }
            }
        }
        stage('build docker image') {

            steps {
                script {
                    buildImage 'hemu07/hemali_repo:jma-7.0'
                    dockerLogin()
                    dockerPush 'hemu07/hemali_repo:jma-7.0'
                    
                    }
                }
            }
        
        stage('deploying the app') {
            steps {
                script {
                   gv.deployApp()
                }
            }
        }   
    }
}
