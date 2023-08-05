from model.api.proxy.project_proxy import invoice_create_new_project
from model.api.request.bitbucket.project_request import RequestGenerateProject
from util.builder.bitbucket.project_builder_response import builder_response_new_project


def create_new_project(project_request: RequestGenerateProject):
    project = project_request.project
    workspace = project_request.workspace

    response_call_api_bitbucket = invoice_create_new_project(workspace=workspace,
                                                             project=project)

    response_builder = builder_response_new_project(response_call_api_bitbucket)

    return response_builder
