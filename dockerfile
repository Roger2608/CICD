FROM python:3.11.3

WORKDIR /CICD

COPY ./requirements.txt /CICD/requirements.txt

RUN pip install --no-cache-dir --upgrade -r /CICD/requirements.txt

COPY ./ /CICD/

CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]