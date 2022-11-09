def codeQuality()
{
    stage('Code Quality') {
            echo 'Code Quality'
    }
}
def styleChecks()
{
    if ( BRANCH_NAME == "main" || TAG_NAME ==~ ".*" ){
        stage('Style Checks') {
            echo 'Style Checks'

        }
    }
}

