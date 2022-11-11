def call() {
    env.APPTYPE = "python"
    node {
        try {
            common.codeCheckout()
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
        } catch (Exception e) {
            mail bcc: '', body: 'build failed ${RUN_DISPLAY_URL}', cc: '', from: 'nayeem0772@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'nayeem0772@gmail.com'
        }
    }

}


//def call() {
//
//    pipeline {
//
//        agent any
//
//        stages {
//
//            stage('Code Quality') {
//                steps {
//                    echo 'Code Quality'
//                    sh 'env'
//                }
//            }
//
//            stage('Style Checks') {
//                when
//                        {
//                            anyOf
//                                    {
//                                        branch 'main'
//                                        tag "*"
//                                    }
//
//                        }
//                steps {
//                    echo 'Code Quality'
//                }
//            }
//
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
//
//    }
//
//
//}