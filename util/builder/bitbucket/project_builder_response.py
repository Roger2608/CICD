import json

from requests import Response

from model.api.response.bitbucket.project_response import ResponseGenerateProject


def builder_response_new_project(response: Response):
    json_parsed = json.loads(response.text)
    name_project = json_parsed['name']
    created_on = json_parsed['created_on']
    key_project = json_parsed['key']
    uuid = json_parsed['uuid']
    url_project = json_parsed['links']['html']['href']

    response = ResponseGenerateProject(key=key_project,
                                       name_project=name_project,
                                       url=url_project,
                                       created_on=created_on,
                                       uuid=uuid)
    return response
