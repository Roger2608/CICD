folder("${app}/my-components") {
  displayName("my-components")
  description("Descripción del Folder para componentes de ${app}")
}
folder("${app}/my-components/${name}") {
  displayName("${name}")
  description("Descripción del Folder del componente a crear")
}
folder("${app}/my-components/${name}/dev") {
  displayName("dev")
  description("Descripción del Folder del componente a crear")
}
folder("${app}/my-components/${name}/cert") {
  displayName("cert")
  description("Descripción del Folder del componente a crear")
}
folder("${app}/my-components/${name}/prod") {
  displayName("prod")
  description("Descripción del Folder del componente a crear")

}
pipelineJob("${app}/my-components/${name}/dev/${name}_dev") {
      definition {
        cpsScmFlowDefinition{
            scm {
                gitSCM {
                    userRemoteConfigs {
                            userRemoteConfig {
                                url('https://github.com/Roger2608/CICD.git')
                                credentialsId('github')
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
            scriptPath('devops//jenkins/dev/Jenkinsfile')
        }
      }
    }



pipelineJob("${app}/my-components/${name}/cert/${name}_cert") {
      definition {
        cpsScmFlowDefinition{
            scm {
                gitSCM {
                    userRemoteConfigs {
                            userRemoteConfig {
                                url('https://github.com/Roger2608/CICD.git')
                                credentialsId('github')
                                name('origin')
                                refspec('')
                            }
                    }
                    branches {
                        branchSpec {
                            name('develop')
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
            scriptPath('devops//jenkins/cert/Jenkinsfile')
        }
      }
    }

pipelineJob("${app}/my-components/${name}/prod/${name}_prod") {
      definition {
        cpsScmFlowDefinition{
            scm {
                gitSCM {
                    userRemoteConfigs {
                            userRemoteConfig {
                                url('https://github.com/Roger2608/CICD.git')
                                credentialsId('github')
                                name('origin')
                                refspec('')
                            }
                    }
                    branches {
                        branchSpec {
                            name('master')
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
            scriptPath('devops//jenkins/prod/Jenkinsfile')
        }
      }
    }
