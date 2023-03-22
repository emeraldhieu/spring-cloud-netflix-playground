# Spring Cloud Netflix Eureka Playground

## Quickstart

### 1) Start apps

+ Start `EurekaServer`
+ Start `EurekaClient`
+ Start `EurekaFeignClient`

### 2) Access Eureka Server

Open `http://localhost:8761` and observe information

### 3) Play

#### Eureka Client

Since the server's port is dynamic, find and copy it from `EurekaClientApp`'s console
```shell
curl http://localhost:<port>/greeting
``` 

Response
```
Hello from 'SPRING-CLOUD-EUREKA-CLIENT'!
```

#### Eureka Feign Client

```shell
curl http://localhost:8080/get-greeting
``` 

Response
```
SPRING-CLOUD-EUREKA-FEIGN-CLIENT is calling...</br>
Hello from 'SPRING-CLOUD-EUREKA-CLIENT'!
```

## References

https://cloud.spring.io/spring-cloud-netflix/reference/html/