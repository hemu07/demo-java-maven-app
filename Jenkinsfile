pipeline {
    
    agent any

    stages {

        stage("build") {
            
            steps {
                echo "building the application.."
            
        }

        stage("test") {

            steps {
                echo "testing the app.."
            }
        } 

        stage("deploy") {

            steps {
                echo "deploying the app..."
            }
        }
    }
    post {
        always {       // runs always whether the pipeline fails or succeeds
            echo "executed the pipeline with imageversion .. "
        }
        success {    // executed when pipeline succeeds
            echo "pipeline succeded.. ci is completed"
        }
        failure {   // executed when pipeline fails
            echo "pipeline failed.. error code is sent to slack/mail "
        }
    }
}
