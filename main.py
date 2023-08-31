from fastapi import FastAPI

from api.expose.azure import resource_controller as azure
from api.expose.bitbucket import repository_controller as repository, project_controller as project
from api.expose.jenkins import jenkins_controller as jenkins

app = FastAPI()

app.include_router(project.project_route)
app.include_router(repository.repository_route)
app.include_router(jenkins.jenkins_route)
app.include_router(azure.resource_group_route)
#app.include_router(azure.resource_group_route)
