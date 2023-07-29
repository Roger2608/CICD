folder("${appName}") {
  		displayName("${appName}")
        description("Descripción del Folder para proyecto ${appName}")
	job("${appName}/job_${appName}_for_components") {
		description('Job DSL para generar un nuevo Job')
		parameters {
    stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
		// Define los pasos para clonar el repositorio privado utilizando las credenciales
		scm {
			git {
				remote {
					url('https://github.com/Roger2608/CICD.git')
					credentials('JenkinsGithub')
				}
				branch('*/feature/jobDSLForAPP')
			}
		}
	}
}
