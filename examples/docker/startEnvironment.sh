#!/bin/bash
#python -m maestro -f maestro.yaml start
docker run -d -p 27017:27017 -p 28017:28017 --name=tracee-example-graylog-mongodb-1 tracee-example-graylog-mongodb
docker run -d -p 9200:9200 -p 9300:9300 --name=tracee-example-graylog-elasticsearch-1 tracee-example-graylog-elasticsearch
docker run -d -p 12900:12900 -link tracee-example-graylog-mongodb-1:mongo -link tracee-example-graylog-elasticsearch-1:elasticsearch --name=tracee-example-graylog-server-1 tracee-example-graylog-server
docker run -d -p 9000:9000 -link tracee-example-graylog-server-1:graylog --name=tracee-example-graylog-web-1 tracee-example-graylog-web
docker run -d -p 8080:8080 -link tracee-example-graylog-server-1:graylog --name=tracee-example-tomcat7-1 tracee-example-tomcat7
