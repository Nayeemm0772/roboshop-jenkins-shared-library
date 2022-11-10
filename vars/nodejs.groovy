def call()  {

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