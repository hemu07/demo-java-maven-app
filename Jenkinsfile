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
        stage ("build image") {
            steps {
                script {
                    buildImage()
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
