from fastapi import APIRouter

from model.api.request.jenkins.job_request import RequestBuildJob
from service.jenkins import job_service as js

jenkins_route = APIRouter()


@jenkins_route.post("/jenkins/build")
def build_job_app(new_project: RequestBuildJob):
    response = js.build_job_jenkins(new_project)
    return response
