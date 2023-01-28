pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh 4 mac
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                 powershell  "docker build -t='orlio/vinsdockerselenium-docker' ."
                }
        }
        stage('Push Image') {
            steps {
                    powershell "docker login --username=orlio --password=DOCKERiVEoRLANDO_85"
                    powershell "docker push orlio/vinsdockerselenium-docker:latest"

                }
            }
        }
    }

