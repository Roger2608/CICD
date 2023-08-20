from fastapi import APIRouter

from model.api.request.azure.resource_group_request import RequestCreateResourceGroup
from service.azure import resource_group_service as rg_service

resource_group_route = APIRouter()


@resource_group_route.post("azure/create/resource_group")
def create_resource_group(new_resource: RequestCreateResourceGroup):
    return rg_service.create_resource_group(new_resource)
