from pydantic.dataclasses import dataclass


@dataclass
class RequestBuildJob:
    name_job: str
    params: dict
