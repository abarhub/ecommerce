# ecommerce

Pour builder le docker compose :
```shell
docker-compose up --build
```

Le dashboard eureka est ici : http://localhost:8761/

la page pour gérer les produits est : http://localhost:19090/ui/product3.html

Pour insteller zipkin :
```shell
docker run -p 9411:9411 openzipkin/zipkin:latest
```
Il est accessible dans http://localhost:9411

La page pour gérer les produits est : http://localhost:9411/ui/product3.html

Pour executer le test de charge, 
il faut aller dans le module loadtesting, et executer :
```shell
mvn gatling:test
```

Les url:

gestion des produits : http://localhost:19090/ui/product3.html

log zipkin : http://localhost:9411

dashboard eureka : http://localhost:8761/






