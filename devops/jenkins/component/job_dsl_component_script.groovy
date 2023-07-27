pipeline {
    parameters {
        string(name: 'NameApp', defaultValue: '', description: 'Nombre de la aplicación para el Job DSL')
    }
    agent any
    stages {
        stage('Clonar Repositorio') {
            steps {
                // Utiliza las credenciales de Jenkins para acceder al repositorio privado
                withCredentials([usernamePassword(credentialsId: 'JenkinsGithub', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
                    // Clonar el repositorio privado utilizando las credenciales proporcionadas
                    sh "git clone https://${GIT_USERNAME}:${GIT_PASSWORD}@https://github.com/Roger2608/CICD.git"
                }
            }
        }
        stage('Generar Job DSL') {
            steps {
                script {
                    def dslScriptPath = 'path/to/dsl_script.groovy'
                    def generatedDSL

                    // Validar que se haya proporcionado un valor para el parámetro NameApp
                    if (params.NameApp == '') {
                        error('¡Por favor, proporciona un valor para el parámetro NameApp!')
                    }

                    // Aquí puedes agregar parámetros o configuraciones adicionales para el DSL, si es necesario

                    // Ejecutar el script Job DSL
                    generatedDSL = load(dslScriptPath)

                    // Almacenar el resultado del DSL generado para su posterior uso
                    writeFile file: "generated_dsl_${params.NameApp}.groovy", text: generatedDSL
                }
            }
        }
        stage('Crear Folder y Job DSL') {
            steps {
                script {
                    def folderName = params.NameApp
                    def generatedDSLPath = "generated_dsl_${folderName}.groovy"

                    // Crear el folder con el nombre proporcionado
                    folder(folderName) {
                        // Crear el nuevo job DSL dentro del folder
                        jobDsl targets: generatedDSLPath

                        // Si tienes más pasos o configuraciones que deseas agregar al Job DSL creado,
                        // puedes hacerlo aquí utilizando los pasos de Jenkins que desees.
                    }
                }
            }
        }
    }
}

