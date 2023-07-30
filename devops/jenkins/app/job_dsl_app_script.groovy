folder("${appName}") {
  		displayName("${appName}")
        description("Descripción del Folder para proyecto ${appName}")
	job("${appName}/job_${appName}_for_components") {
		description('Job DSL para generar un nuevo Job')
		parameters {
    stringParam('name', defaultValue = 'write_name_of_component', description = 'name of component')
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
		steps {
    dsl {
      external('devops/jenkins/component/job_dsl_component_script.groovy')
    }
  }
	}
}
