const mqtt = require('mqtt')

const host = 'aws-ca-retail.messaging.solace.cloud'
const port = '1883'
const clientId = `mqtt_${Math.random().toString(16).slice(3)}`
const topicRoot = 'acme/instore/instock/stk/restock/expiring'

const connectUrl = `mqtt://${host}:${port}`
const client = mqtt.connect(connectUrl, {
  clientId,
  clean: true,
  connectTimeout: 4000,
  username: 'public',
  password: 'public',
  reconnectPeriod: 1000,
})

const expiryDate = new Date()
const topic = 'acme/instore/instock/stk/restock/created/v1/+/+/+/+/+/+'
client.on('connect', () => {
  console.log('Connected')
  client.subscribe([topic], () => {
    console.log(`Subscribe to topic '${topic}'`)
  })
})
client.on('message', (topic, payload) => {
  // console.log(`Received Message on: ${topic}\n ${payload.toString()}`)
  console.log(`Received Message on: ${topic}`)
  body = JSON.parse(payload);
  let expiring = Math.random() < 0.5;
  let splitTopic = topic.split('/');
  let topicTail = ""; 

  for (let i = 6; i < splitTopic.length; i++){
    topicTail = topicTail + "/" + splitTopic[i];
  }
  console.log(body.expiration_date);

  if (expiring) {
    let newTopic = topicRoot + topicTail;
    console.log("Product expiring " + newTopic);
    client.publish(newTopic, payload);
  }



})

