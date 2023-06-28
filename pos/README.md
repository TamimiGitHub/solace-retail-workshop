# POS System

This microservice emulates a POS system 

### Example topic
publish
- `acme/instore/instock/stk/restock/consumed/v1/NW/00002/dairy/milk/BATCH-06272023-002/1687809260`

## Technology
<img src="../img/scst.png" width="20%" height="20%">

Spring Cloud Stream Application

## How to run
1. Generate your application
```
asyncapi generate fromTemplate Point\ of\ Sale-0.1.0.yaml @asyncapi/java-spring-cloud-stream-template -o TEST -p binder=solace -p dynamicType=header -p artifactId=FraudDetection -p groupId=org.fraud.detection -p javaPackage=org.fraud.detection -p host=<host> -p username=<username> -p password=password -p msgVpn=use-east
```
1. Logic
