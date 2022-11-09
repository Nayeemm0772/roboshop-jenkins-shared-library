def codeQuality()
{
    stage('Code Quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')])
        sh '''
            sonar-scanner -D sonar.host.url=http://172.31.6.176:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=$(COMPONENT)
        '''
    }
}

def codeChecks()    {
    if ( env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*" ){

        stage('Style Checks') {
            echo 'Style Checks'
        }

        stage('unit tests') {
            echo 'unit tests'
        }
    }
}

def artifacts()     {
    if ( env.TAG_NAME ==~ ".*" ) {

        stage('Download Dependencies')  {
                echo 'Download Dependencies'
        }

        stage('Prepare Artifact') {
                echo 'Prepare Artifact'
        }

        stage('Publish Artifact') {
                echo 'Publish Artifact'
        }


    }

}

