def codeQuality()
{
    stage('Code Quality') {
            echo 'Code Quality'
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

