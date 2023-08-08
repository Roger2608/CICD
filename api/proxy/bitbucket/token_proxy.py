import requests

from util.constants import AUTHORIZATION_GENERATE_TOKEN, GRANT_TYPE, URL_BITBUCKET_ACCESS_TOKEN


def get_access_token():
    url = URL_BITBUCKET_ACCESS_TOKEN
    headers = {
        'Authorization': f'Basic {AUTHORIZATION_GENERATE_TOKEN}'
    }
    data = {
        'grant_type': GRANT_TYPE
    }

    response = requests.post(url, headers=headers, data=data)

    if response.status_code == 200:
        access_token = response.json().get('access_token')
        return access_token
    else:
        print('Error:', response.status_code, response.text)
