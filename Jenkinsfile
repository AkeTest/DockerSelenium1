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
                 powershell  "docker build -t='vinsdocker/selenium-docker' ."
                }
        }
        stage('Push Image') {
            steps {
                    powershell "docker login --username=${oRLIO} --password=${DOCKERiVEoRLANDO_85}"
                    powershell "docker push vinsdocker/selenium-docker:latest"

                }
            }
        }
    }

