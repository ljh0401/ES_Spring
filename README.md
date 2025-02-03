# Elastic Search Spring 구현 연습

MySQL
```shell
docker run --name dolang-mysql `
 -e MYSQL_ROOT_PASSWORD=password `
 -e MYSQL_DATABASE=dolang `
 -e MYSQL_USER=user `
 -e MYSQL_PASSWORD=password `
 -p 3306:3306 `
 -d mysql:8.0.41
```

ElasticSearch
```shell
docker run --name dolang-es `
-p 9200:9200 `
-e "ELASTIC_PASSWORD=password"`
-e "xpack.security.enabled=true"`
-e "discovery.type=single-node"`
-e "ES_JAVA_OPTS=-Xms1g -Xmx2g"`
-d docker.elastic.co/elasticsearch/elasticsearch:8.17.1
```
