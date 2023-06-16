# Azure Functions

This folder contains a list of Azure functions that will be triggered via Solace RDP

## Functions

<img src="./img/azure.png" width=50% height=50%>

| Function Name  | Description | Trigger Topic | 
| ------------- | ------------- | ------------- |
| PowerBI_POS  | This function parses a JSON body from the POS microservice, extracts the data plots them on a PowerBI dashboard  | t/t/t/ |
| PowerBI_STOCK   | This function parses a JSON body from the restocking microservice, extracts the data plots them on a PowerBI dashboard  | t/t/t/ |
| DB   | This function adds data to a database  | t/t/t/ |

## How to run