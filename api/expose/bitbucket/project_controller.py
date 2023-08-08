from fastapi import APIRouter

from model.api.request.bitbucket.project_request import RequestGenerateProject
from service.bitbucket import project_service as ps

project_route = APIRouter()


@project_route.post("/bitbucket/create/project")
def generate_project(new_project: RequestGenerateProject):
    response = ps.create_new_project(new_project)
    return response
