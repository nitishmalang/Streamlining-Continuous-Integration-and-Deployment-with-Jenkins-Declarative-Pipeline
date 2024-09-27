pipeline {
  agent any
  stages {
    stage('Code Clone') {
      steps {
        git 'https://github.com/nitishmalang/django-notes-app.git'
      }
    }
    stage('Build') {
      steps {
        sh 'docker build -t my-note-app .'
      }
    }
    stage('Push to Docker Hub') {
      steps {
        withCredentials([string(credentialsId: 'docker-hub-password', variable: 'DOCKER_HUB_PASS')]) {
          sh 'docker login -u nitishmalang -p $DOCKER_HUB_PASS'
          sh 'docker push nitishmalang/my-note-app:latest'
        }
      }
    }
    stage('Deploy') {
      steps {
        sh 'docker-compose down'
        sh 'docker-compose up -d'
      }
    }
  }
}
