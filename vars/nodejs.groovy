def call()  {

    node {
            sh 'env'
            common.codeQuality()
            if ( BRANCH_NAME == "main" || TAG_NAME ==~ "*" ){
            stage('Style Checks') {
                    echo 'Style Checks'

            }
        }


//            stage('Unit Tests') {
//                when
//                        {
//                            anyOf
//                                    {
//                                        branch 'main'
//                                        tag "*"
//                                    }
//                        }
//                steps {
//                    echo 'Code Quality'
//                }
//            }
//

//            stage('Prepare Artifact') {
//                when { tag "*"}
//                steps {
//                    echo 'Prepare Artifact'
//                }
//            }
//
//            stage('Publish Artifact') {
//                when { tag "*"}
//                steps {
//                    echo 'Publish Artifact'
//                }
//            }
//
//
//
//        }

    }



}