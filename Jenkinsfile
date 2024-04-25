#!/usr/bin/env groovy

@Library('jenkins-shared-library')

def gv 

pipeline {  
    agent any 
    tools {
        maven 'maven-3.9.6'
    }
    stages {
        stage ("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage ("build jar") {
            steps {
                script {
                   buildApp()
                }
            }
        }
        stage ("build image & push image") {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    buildImage 'hemu07/hemali_repo:jma-7.0'
                    dockerLogin()
                    dockerPush 'hemu07/hemali_repo:jma-7.0'
                    
                    }
                }
            }
        stage ("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
