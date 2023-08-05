from pydantic.dataclasses import dataclass


@dataclass
class CreateProject:
    key: str
    name: str
    description: str
    is_private: bool
