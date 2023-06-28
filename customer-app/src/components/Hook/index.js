import React, { useEffect, useState } from "react";
import {Button, Card, Col} from "antd";
import Receiver from "./Receiver";
import mqtt from "mqtt";
import { ApiOutlined } from '@ant-design/icons';

const HookMqtt = () => {
  const [client, setClient] = useState(null);
  const [subTopic, setSubscription] = useState(null);
  const [isSubed, setIsSub] = useState(false);
  const [isConnected, setIsConnected] = useState(false);
  const [payload, setPayload] = useState({});
  
  var startTime = new Date();

  const mqttConnect = (host, mqttOption) => {
    console.log(`Connecting to ${host} with options:`, mqttOption);
    setClient(mqtt.connect(host, mqttOption));
    setIsConnected(true)
  };

  useEffect(() => {
    if (client) {
      client.on("connect", () => {
        console.log(`Connected to client: ${client.options.host}`)
        console.log(`Subscribing to: ${subTopic}`)
        mqttSub(subTopic)
      });
      client.on("error", (err) => {
        console.error("Connection error: ", err);
        client.end();
      });
      client.on("reconnect", () => {
        console.log(`Reconnecting to client: ${client.options.host}`)
      });
      client.on("message", (topic, message) => {
        // throttle the messages
        let endTime = new Date()
        var timeDiff = endTime - startTime
        timeDiff /= 1000
        // var seconds = Math.round(timeDiff)
        if (timeDiff > 0.5){
          const payload = { topic, message: message.toString() };
          startTime = new Date()
          setPayload(payload);
        }
      });
    }
  }, [client]);

  const mqttDisconnect = (currHost) => {
    if (client.options.host !== currHost.split("//")[1]) {
      client.end(() => {
        console.log(`Disconnected from : ${client.options.host}`)
        setIsConnected(false)
        setClient(null)
      });
    }
  };

  const mqttSub = (topic) => {
    if (client) {
      client.subscribe(topic, (error) => {
        if (error) {
          console.log("Subscribe to topics error", error);
          return;
        }
        setIsSub(true);
      });
    }
  };

  const handleConnect = (stream) => {
    client ? console.log(`MQTT client already connected to: ${client.options.host}`) : console.log("No connected client")
    const options = {
      keepalive: 30,
      protocolId: "MQTT",
      protocolVersion: 4,
      clean: true,
      reconnectPeriod: 1000,
      connectTimeout: 30 * 1000,
      will: {
        topic: "WillMsg",
        payload: "Connection Closed abnormally..!",
        qos: 0,
        retain: false,
      },
      rejectUnauthorized: false,
    };
    options.username = stream.username;
    options.password = stream.password;
    setSubscription(`${stream.topicPrefix}/#`)
    if (client) {
      mqttDisconnect(stream.host) 
      mqttConnect(stream.host, options)
    } else {
      mqttConnect(stream.host, options)
    }
  };

  const handleDisconnect = (host) => {
    mqttDisconnect(host)
  }

  // do logic for expiry date
const expiryDate = new Date()
const streams = [
  {
    id: "store",
    name: "Connect to store",
    host: "wss://aws-ca-retail.messaging.solace.cloud:8443",
    username: "public",
    password: "public",
    topicPrefix: ""
  },
]
  return (
    <>
    <h1 style={{color: "white"}}>Hot Dealz</h1>
      <Card>
        {isConnected && isSubed ? (
            <ApiOutlined style={{ color: "green" }}/>
          ) : (
            <ApiOutlined/>
        )}
        <Col>
        {streams.map((stream) =>(
          <Button key={stream.id} onClick={() => {handleConnect(stream)}}>{stream.name}</Button>  
        ))}
        {isConnected ? (
          <Button danger onClick={() => {handleDisconnect("all")}}>Disconnect</Button>  
          ) : (
            ""
        )}
        </Col>
      </Card>
      <Receiver payload={payload} />
    </>
  );
};

export default HookMqtt;
