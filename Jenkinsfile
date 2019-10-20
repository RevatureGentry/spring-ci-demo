pipeline {
    agent any
    stages {
        stage('Setup') {
           steps {
                sh 'mvn verify sonar:sonar -Dsonar.projectKey="${env.SONAR_CLOUD_ORGANIZATION}" -Dsonar.organization="${env.SPRING_SC_PROJECT_KEY}" -Dsonar.host.url=https://sonarcloud.io Dsonar.login="${env.SONAR_CLOUD_TOKEN}"'
           }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Analyze') {
            steps {
                sh 'mvn sonar:sonar'
            }
        }
    }
}
