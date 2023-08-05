import json

import requests

from model.entities.bitbucket.repository_entity import CreateRepository
from util import constants as const
from service.bitbucket import token_service as token


def invoice_create_new_repository(workspace: str, repository: CreateRepository):
    url = f"{const.API_BITBUCKET}/repositories/{workspace}/{repository.slug}"

    headers = {
        "Accept": const.ACCEPT__CONTENT_TYPE,
        "Content-Type": const.ACCEPT__CONTENT_TYPE,
        "Authorization": f"Bearer {token.get_access_token()}"
    }

    payload = json.dumps({
        "is_private": repository.is_private,
        "name": repository.name,
        "description": repository.description,
        "has_issues": repository.has_issues,
        "has_wiki": repository.has_wiki,
        "project": {
            "key": repository.project
        }
    })

    response = requests.request(
        method=const.METHOD_POST,
        url=url,
        data=payload,
        headers=headers
    )
    return response
