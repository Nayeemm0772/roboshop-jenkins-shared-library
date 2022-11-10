def codeCheckout() {
    stage('code checkout')  {
        sh 'find . | sed 1d | xargs rm -rf '
        git branch: 'main', url: "https://github.com/Nayeemm0772/${COMPONENT}.git"
    }
}
def codeQuality()
{
    stage('Code Quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            sh '''
                # sonar-scanner -Dsonar.host.url=http://172.31.6.176:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
                echo OK
        '''

        }
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

