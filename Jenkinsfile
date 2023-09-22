@Library('ceiba-jenkins-library') _
pipeline{
    //Donde se va a ejecutar el Pipeline
	agent {
        label 'Slave_Induccion'
    }

    //Opciones específicas de Pipeline dentro del Pipeline
    options {
        	buildDiscarder(logRotator(numToKeepStr: '3'))
     		disableConcurrentBuilds()
    }

    // Determinar si dejar o quitar
    /*
    environment {
        PROJECT_PATH_BACK = 'cliente'
    }
    */

    // Determinar si dejar o quitar
    /*
    triggers {
        // @yearly, @annually, @monthly, @weekly, @daily, @midnight, and @hourly o definir un intervalo. Ej: H */4 * * 1-5
        pollSCM('@weekly') //define un intervalo regular en el que Jenkins debería verificar los cambios de fuente nuevos
    }
    */

    //Una sección que define las herramientas “preinstaladas” en Jenkins. TODO: Validar que sí sea JDK17_Centos. Validar si es necesario NodeJS.
    tools {
        jdk 'JDK17_Centos'
        nodejs 'NodeJS15'
    }

    // Parámetros disponibles en jenkins. Podrían ser útiles en otra implementación
     /*
     parameters{
            string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
            text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
            booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
            choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
            password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a passwor')
     }
     */

    stages{
        stage('Checkout') {
          steps{
            echo "------------>Checkout<------------"
            checkout scm
          }
        }

        stage('Clean') {
          steps{
             echo "------------>Clean<------------"
             sh 'chmod +x ./microservicio/gradlew'
             sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
          }
        }

        stage('Compile & Unit Tests') {
          steps{
            echo "------------>compile & Unit Tests<------------"
            sh 'chmod +x ./microservicio/gradlew'
            sh './microservicio/gradlew --b ./microservicio/build.gradle test'
          }
        }

        // TODO: Pendiente. Si hay bloqueos preguntarle a Carlos Eduardo Báez Coronado
        stage('Static Code Analysis') {
          steps {
            echo '------------>Análisis de código estático<------------'
            sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:[papeleria-juan.gutierrez]',
            sonarName:'ADN-Papeleria[juan.gutierrez]',
            sonarPathProperties:'./sonar-project.properties')
          }
        }

        stage('Build') {
          steps {
            echo "------------>Build<------------"
                //Construir sin tarea test que se ejecutó previamente
                sh './microservicio/gradlew --b ./microservicio/build.gradle build -x test'
          }
        }
    }

    post {
        always {
          echo 'This will always run'
        }
        success {
          echo 'This will run only if successful'
          junit '**/test-results/test/*.xml'
        }
        failure {
          echo 'This will run only if failed'
          mail (
            to: 'juan.gutierrez@ceiba.com.co',
            subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
            body: "Something is wrong with ${env.BUILD_URL}"
          )
        }
        unstable {
          echo 'This will run only if the run was marked as unstable'
        }
        changed {
          echo 'This will run only if the state of the Pipeline has changed'
          echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }

}
