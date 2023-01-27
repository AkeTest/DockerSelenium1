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
                 bat "docker build -t= 'vinsdocker/selenium-docker' ."
                }
        }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId:'dockerhub',passwordVariable:'DOCKERiVEoRLANDO_85', usernameVariable: 'oRLIO' ])

                    bat "docker login --username=${oRLIO} --password=${DOCKERiVEoRLANDO_85}"
                    bat "docker push vonsdpcker/selenium-docker:latest"

                }
            }
        }
    }
}
