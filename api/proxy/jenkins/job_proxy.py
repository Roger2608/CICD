import jenkins

from util import constants as const


def get_access_token():
    server = jenkins.Jenkins(url=const.URL_API_JENKINS,
                             username=const.USER_API_JENKINS,
                             password=const.TOKEN_API_JENKINS
                             )
    return server


def build_job(name_job: str, params: dict):
    server = get_access_token()
    print(server.get_all_jobs())
    server.build_job(name=name_job, parameters=params)
    last_build_number = server.get_job_info(name=name_job)['lastCompletedBuild']['number']
    build_info = server.get_build_info(name_job, last_build_number)
    return build_info
