def codeQuality()
{
    stage('Code Quality') {
            echo 'Code Quality'
    }
}

def codeChecks()    {
    if ( BRANCH_NAME == "main" || TAG_NAME ==~ ".*" ){

        stage('Style Checks') {
            echo 'Style Checks'
        }

        stage('unit tests') {
            echo 'unit tests'
        }
    }
}

def artifacts()     {
    if ( TAG_NAME ==~ ".*" ) {

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

