from pydantic.dataclasses import dataclass


@dataclass
class CreateRepository:
    is_private: bool
    name: str
    description: str
    has_issues: bool
    has_wiki: bool
    project: str
    slug: str
