# Retail Workshop

This repo contains several microservices that will emulate a grocery store with the following activities.

The documentation of all the applications, topics and schemas is found in the Solace PubSub+ Event Portal. The EP configuration can be downloaded and imported in to the event portal.

### In Store
- [Restocking system](./restock) - Responsible for stocking the inventory with new produce. Spring cloud streams java app.
- [POS System](./pos/) - Responsible for checking shoppers out. Spring cloud streams java app
- [Associate Device](./associate/) - Used by associates to update current inventory and receive information on inventory status. A javascript application that leverages the Solace JS SDK and MQTT

### User interaction 
- [Customer Application](./customer-app/) - Alerts customers on potential discounts. This applicaton is a javascript application that leverages Solace JS SDK to do WS. 

### Backend
- [Azure Functions](./functions/)
  - Updating PowerBI dashboard
  - Updating Azure SQL db
  - Customer also uses singleStoreDB. Could be an alternative database destination to azure sql https://www.singlestore.com/blog/spin-up-a-memsql-cluster-on-docker-desktop-in-10-minutes/
- Connectors
  - Other Solace Connectors
  - Possible .NET application

### Topics Hierarchy
- `{corp}/{pillar}/{domain}/{capability}/{entity}/{action}/{version}/{region}/{location}/{department}/{item}/{batch_id}/{batch_expiry}`

| Topic Level  | Description    |
| ------------- | ------------- |
|corp           | Corporate name|
|pillar         | inStore or OutStore|
|domain         | Team: inStock|
|capability     | Group of microservices that handle stock |
|entity         | Type of object. e.g. restock|
|action         | created, removed...etc |
|version        | v1, v2... |
|region         | US Region e.g. N, NE... |
|location       | 5 byte integer that represents a unique store location. e.g. 00005 |
|department     | milk, produce...etc |
|item           | product |
|batch_id       | batch id: BATCH-{date}-{batch_number} |
|batch_expiry   | the expiry date of the batch. Unix timecode |

Example
- `acme/instore/instock/stk/restock/created/v1/NW/00002/dairy/milk/BATCH-06272023-002/1687809260`


![](./img/arch.png)