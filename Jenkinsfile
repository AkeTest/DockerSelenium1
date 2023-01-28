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
                withCredentials([usernamePassword(credentialsId:'dockerhub',passwordVariable:'DOCKERiVEoRLANDO_85', usernameVariable: 'oRLIO' )])

                    powershell "docker login --username=${oRLIO} --password=${DOCKERiVEoRLANDO_85}"
                    powershell "docker push vinsdocker/selenium-docker:latest"

                }
            }
        }
    }

