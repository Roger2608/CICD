folder("${app}/my-components") {
  displayName("my-components")
  description("Descripción del Folder para componentes de ${app}")
}

import java.util.UUID

multibranchPipelineJob("${app}/my-components/${name}") {
  branchSources {
    git {
      id(UUID.randomUUID().toString())
      remote("https://github.com/Roger2608/${name}.git")
      credentialsId('github')
    }
  }
  orphanedItemStrategy {
    discardOldItems {
      numToKeep(20)
    }
  }
}
