/*pipelineJob('hello-pipeline-inline') {
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
						name('feature/jobDSLForAPP')
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
		scriptPath('devops/jenkins/Jenkinsfile')
	}
  }
}
*/

multibranchPipelineJob('example') {
    branchSources {
        git {
            id('123456789')
            remote('https://github.com/jenkinsci/job-dsl-plugin.git')
            credentialsId('github-ci')
            includes('JENKINS-*')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

