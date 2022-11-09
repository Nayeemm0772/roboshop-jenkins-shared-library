def call()  {

    node {

        if( ! env.TAG_NAME)
        {
            env.TAG_NAME = ""
        }
            common.codeQuality()
            common.styleChecks()


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