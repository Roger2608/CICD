from pydantic.dataclasses import dataclass


@dataclass
class ResponseGenerateProject:
    key: str
    name_project: str
    url: str
    created_on:str
    uuid: str
