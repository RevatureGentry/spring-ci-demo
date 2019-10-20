pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Analyze') {
            steps {
                sh 'mvn verify sonar:sonar -Dsonar.projectKey=$SPRING_SC_PROJECT_KEY -Dsonar.organization=$SONAR_CLOUD_ORGANIZATION -Dsonar.host.url=https://sonarcloud.io Dsonar.login=$SONAR_CLOUD_TOKEN'
            }
        }
    }
}
