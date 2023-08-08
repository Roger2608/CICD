from api.proxy.jenkins import job_proxy as jp
from model.api.request.jenkins.job_request import RequestBuildJob


def build_job_jenkins(build_job_request: RequestBuildJob):
    name_job = build_job_request.name_job
    params_dict = build_job_request.params

    response = jp.build_job(name_job, params_dict)
    return response
