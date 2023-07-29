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
				browser {
					gitWeb {
						repoUrl('https://github.com/Roger2608/CICD.git')
					}
				}
				gitTool('/usr/bin/git')
			}
		}
		lightweight(true)
		scriptPath('Jenkinsfile')
	}
  }
}
