def mvnHome
node {
    mvnHome = tool 'M3'
    stage('Checkout') {
        git url: 'https://github.com/joelbinn/jenkins-pipeline.git'
    }
    stage('Build') {
        // Run the maven build
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' -DskipTests clean install"
        } else {
            bat(/"${mvnHome}\bin\mvn" -DskipTests clean install/)
        }
    }
}

parallel 'Unit test': {
    node {
        stage('Unit test') {
            if (isUnix()) {
                sh "'${mvnHome}/bin/mvn' -f app test"
            } else {
                bat(/"${mvnHome}\bin\mvn" -f app test/)
            }
        }
    }
}, 'BDD test': {
    node {
        stage('BDD test') {
            if (isUnix()) {
                sh "'${mvnHome}/bin/mvn' -f bdd test"
            } else {
                bat(/"${mvnHome}\bin\mvn" -f bdd test/)
            }
        }
    }
}


