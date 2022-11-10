
def call() {
    env.SONAR_EXTRA_OPTS = "-Dsonar.java.binaries=./target"
   // env.APPTYPE = "java"
    node {
        try {
            common.codeCheckout()
            stage('Compile Code') {
                sh 'mvn compile'
            }
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
        } catch (Exception e) {
            mail bcc: '', body: 'build failed ${RUN_DISPLAY_URL}', cc: '', from: 'nayeem0772@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'nayeem0772@gmail.com'
        }

    }

}




//def call() {
//    pipeline {
//
//        agent any
//
//        stages {
//
//            stage('compile code'){
//                steps {
//                    echo 'compile code'
//                }
//            }
//
//
//            stage('Code Quality') {
//                steps {
//                    echo 'Code Quality'
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
//                    echo 'style checks'
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
//                    echo 'Unit Tests'
//                }
//            }
//
//
//
//            stage('Build package') {
//                when { tag "*"}
//                steps {
//                    echo 'Download Dependencies'
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
//
//    }
//
//
//}