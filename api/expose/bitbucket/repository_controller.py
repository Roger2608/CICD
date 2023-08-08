from fastapi import APIRouter

from model.api.request.bitbucket.repository_request import RequestGenerateRepository
from service.bitbucket import repository_service as rs

repository_route = APIRouter()


@repository_route.post("/bitbucket/create/repository")
def generate_repository(new_repository: RequestGenerateRepository):
    response = rs.create_new_repository(new_repository)
    return response
