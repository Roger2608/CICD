from pydantic.dataclasses import dataclass

from model.entities.bitbucket.repository_entity import CreateRepository


@dataclass
class RequestGenerateRepository:
    workspace: str
    repository: CreateRepository
