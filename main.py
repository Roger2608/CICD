from fastapi import FastAPI

from model.api.expose import project_controller as project
from model.api.expose import repository_controller as repository

app = FastAPI()

app.include_router(project.project_route)
app.include_router(repository.repository_route)
