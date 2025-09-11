pipeline {
    agent any

    tools {
        allure 'allure'
    }

    parameters {
        string(name: 'browser', defaultValue: 'chrome', description: 'Browser to use for tests')
        string(name: 'threadCount', defaultValue: '2', description: 'Number of parallel threads')
        string(name: 'config', defaultValue: 'all_tests', description: 'TestNG suite file without .xml')
        string(name: 'branch', defaultValue: 'https://github.com/Vitald75/AQA_FullStack_2025.git', description: 'Branch from which test will be launched')

        booleanParam(name: 'selenoidEnable', defaultValue: true, description: 'Enable running on Selenoid')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: ${branch}, credentialsId: 'github-token'
            }


        }
    }
}