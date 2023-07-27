// Definición del Job DSL
job('JobDSL_GenerateJob') {
    description('Job DSL para generar un nuevo Job')

    // Define los pasos para clonar el repositorio privado utilizando las credenciales
    scm {
        git {
            remote {
                url('https://github.com/Roger2608/CICD.git')
                credentials('JenkinsGithub')
            }
        }
    }

    // Define el script de Job DSL
    steps {
        script {
            def dslScriptPath = 'devops/jenkins/component/job_dsl_component_script.groovy'
            def generatedDSL

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
