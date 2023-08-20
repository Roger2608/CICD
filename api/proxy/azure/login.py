from azure.identity import DefaultAzureCredential
from azure.mgmt.resource import ResourceManagementClient


def loginDefault(subscription: str):
    # Define tus credenciales
    credential = DefaultAzureCredential()

    # Crea un cliente para administración de recursos
    resource_client = ResourceManagementClient(credential, subscription)

    return resource_client
