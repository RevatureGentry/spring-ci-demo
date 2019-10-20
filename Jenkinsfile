pipeline {
    agent any

    environment {
        MAVEN_OPTS="-Xmx512m"
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -e -U clean install'
            }
        }
        stage('Analyze') {
            steps {
                sh 'mvn -e -U verify sonar:sonar -Dsonar.projectKey=$SPRING_SC_PROJECT_KEY -Dsonar.organization=$SONAR_CLOUD_ORGANIZATION -Dsonar.host.url=https://sonarcloud.io Dsonar.login=$SONAR_CLOUD_TOKEN'
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
