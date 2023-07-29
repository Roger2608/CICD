pipelineJob('hello-pipeline-inline') {
  definition { 
  	cpsScmFlowDefinition{
  		scm {
			gitSCM {
				userRemoteConfigs {
						userRemoteConfig {
							url('https://github.com/Roger2608/CICD.git')
							credentialsId('JenkinsGithub')
							name('origin')
							refspec('')
						}
				}
				branches {
					branchSpec {
						name('*/feature/jobDSLForAPP')
					}
				}
			}
		}
		lightweight('true')
		scriptPath(Jenkinsfile)
	}
  }
}
