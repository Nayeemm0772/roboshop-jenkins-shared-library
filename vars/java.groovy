def call() {
    pipeline {

        agent any

        stages {

            stage('compile code'){
                steps {
                    echo 'compile code'
                }
            }


            stage('Code Quality') {
                steps {
                    echo 'Code Quality'
                }
            }

            stage('Style Checks') {
                when
                        {
                            anyOf
                                    {
                                        branch 'main'
                                        tag "*"
                                    }

                        }
                steps {
                    echo 'style checks'
                }
            }

            stage('Unit Tests') {
                when
                        {
                            anyOf
                                    {
                                        branch 'main'
                                        tag "*"
                                    }
                        }
                steps {
                    echo 'Unit Tests'
                }
            }



            stage('Build package') {
                when { tag "*"}
                steps {
                    echo 'Download Dependencies'
                }
            }

            stage('Prepare Artifact') {
                when { tag "*"}
                steps {
                    echo 'Prepare Artifact'
                }
            }

            stage('Publish Artifact') {
                when { tag "*"}
                steps {
                    echo 'Publish Artifact'
                }
            }



        }

    }


}