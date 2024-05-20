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

        stage("push") {

            steps {
                echo "pushin image to repo.."
            }
        }
        
        stage("deploy") {

            steps {
                echo "deploying the app..."
            }
        }
    }
}
