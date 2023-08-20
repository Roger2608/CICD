from pydantic.dataclasses import dataclass


@dataclass
class RequestCreateResource:
    id_subscription: str
