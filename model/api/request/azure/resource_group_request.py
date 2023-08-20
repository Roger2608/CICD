from pydantic.dataclasses import dataclass


@dataclass
class RequestCreateResourceGroup:
    id_subscription: str
    name: str
    location: str
