pipeline {
    agent any
    options {
        timeout(time: 3, unit: 'MINUTES')
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '5'))
  }

    stages {
        stage('Checkout Git') {
            steps {
                git branch: 'inesBranch', credentialsId: 'jenkins-user-for-org.jacoco.agent', url: 'https://github.com/RhoumaInes/Devops'
            }
        }
        stage('Test Build') {
            steps {
                bat "mvn package"
            }
        }
        
        stage('Sonar') {
            steps {
                bat "mvn sonar:sonar"
            }
        }
    }
}
