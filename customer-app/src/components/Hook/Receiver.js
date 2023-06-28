import React, { useEffect, useState } from "react";
import { Card, List, Button } from "antd";

const Receiver = ({ payload }) => {
  const [messages, setMessages] = useState([]);

  useEffect(() => {
    if (payload.topic) {
      setMessages((messages) => [payload, ...messages]);
    }
  }, [payload]);

  const renderListItem = (item) => {
    return (
      <List.Item>
        <List.Item.Meta title={`Topic: ${item.topic}`} description={item.message} />
      </List.Item>
    );
  };

  const handleClear = () => {
    setMessages([]);
  };

  return (
    <Card title="Dashboard">
      <Button type="danger" style={{ marginLeft: "10px" }} onClick={handleClear}>
        Clear
      </Button>
      <List size="large" bordered dataSource={messages} renderItem={renderListItem} />
    </Card>
  );
};

export default Receiver;
