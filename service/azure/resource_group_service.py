from api.proxy.azure.login import loginDefault
from model.api.request.azure.resource_group_request import RequestCreateResourceGroup


def create_resource_group(new_resource_group: RequestCreateResourceGroup):
    id_subscription = new_resource_group.id_subscription
    location_rg = new_resource_group.location
    name_rg = new_resource_group.name
    azure = loginDefault(id_subscription)

    # Crea el grupo de recursos
    new_rg = azure.resource_groups.create_or_update(name_rg, {'location': location_rg})
    return new_rg
