pipeline {
    
    agent any

    stages {

        stage("build") {
            
            steps {
                echo "building the application.."
            }
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
        always {
            echo "executed the pipeline with imageversion .. "
        }
        success {
            echo "pipeline succeded.. ci is completed"
        }
        failure {
            echo "pipeline failed.. error code is sent to slack/mail "
        }
    }
}
