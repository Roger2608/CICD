from pydantic.dataclasses import dataclass


@dataclass
class ResponseGenerateRepository:
    name_repository: str
    url: str
    created_on: str
    uuid: str
