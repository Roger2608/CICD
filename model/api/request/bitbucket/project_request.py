from pydantic.dataclasses import dataclass

from model.entities.bitbucket.project_entity import CreateProject


@dataclass
class RequestGenerateProject:
    project: CreateProject
    workspace: str
