import json

from requests import Response

from model.api.response.bitbucket.repository_response import ResponseGenerateRepository


def builder_response_new_repository(response: Response):
    json_parsed = json.loads(response.text)
    name_repository = json_parsed['name']
    created_on = json_parsed['created_on']
    uuid = json_parsed['uuid']
    url = json_parsed['links']['html']['href']

    response = ResponseGenerateRepository(name_repository=name_repository,
                                          url=url,
                                          created_on=created_on,
                                          uuid=uuid)
    return response
