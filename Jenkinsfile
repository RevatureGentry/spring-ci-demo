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
                sh 'mvn verify org.sonarsource.scanner.maven:sonar -Dsonar.projectKey=$SONAR_CLOUD_ORGANIZATION -Dsonar.organization=$SPRING_SC_PROJECT_KEY -Dsonar.host.url=https://sonarcloud.io Dsonar.login=$SONAR_CLOUD_TOKEN'
            }
        }
    }
}
