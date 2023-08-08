import json

import requests

from model.entities.bitbucket.project_entity import CreateProject
from api.proxy.bitbucket import token_proxy as token
from util import constants as const


def invoice_create_new_project(workspace: str, project: CreateProject):
    url = f"{const.API_BITBUCKET}/workspaces/{workspace}/projects"

    headers = {
        "Accept": const.ACCEPT__CONTENT_TYPE,
        "Content-Type": const.ACCEPT__CONTENT_TYPE,
        "Authorization": f"Bearer {token.get_access_token()}"
    }
    payload = json.dumps({
        "key": project.key,
        "name": project.name,
        "description": project.description,
        "is_private": project.is_private
    })

    response_invoice = requests.request(
        method=const.METHOD_POST,
        url=url,
        data=payload,
        headers=headers
    )

    return response_invoice
