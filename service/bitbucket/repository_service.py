from api.proxy.bitbucket import repository_proxy as rp
from model.api.request.bitbucket.repository_request import RequestGenerateRepository
from util.builder.bitbucket.repository_builder_response import builder_response_new_repository


def create_new_repository(repository_request: RequestGenerateRepository):
    workspace = repository_request.workspace
    repository = repository_request.repository

    response_call_api_bitbucket = rp.invoice_create_new_repository(workspace=workspace,
                                                                   repository=repository)

    response_builder = builder_response_new_repository(response_call_api_bitbucket)

    return response_builder
