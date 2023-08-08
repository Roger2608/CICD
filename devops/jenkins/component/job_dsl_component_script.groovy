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
import java.util.UUID

folder("${app}/my-components") {
  displayName("my-components")
  description("Descripción del Folder para componentes de ${app}")
}
multibranchPipelineJob("${app}/my-components/${name}") {
  branchSources {
    git {
      id(UUID.randomUUID().toString())
      remote('https://github.com/Roger2608/CICD.git')
      credentialsId('JenkinsGithub')
    }
  }
  orphanedItemStrategy {
    discardOldItems {
      numToKeep(20)
    }
  }
}