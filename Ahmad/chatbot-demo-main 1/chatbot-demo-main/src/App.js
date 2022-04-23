import React from "react";
import "./App.css";
import Chatbot from "react-chatbot-kit";
import config from "./chatbot/Config";
import ActionProvider from "./chatbot/ActionProvider";
import MessageParser from "./chatbot/MessageParser";

function App() {
  return (
    <div className="App">
      <div className="chat-bot" style={{ maxWidth: "300px" }}>
        <Chatbot
          config={config}
          actionProvider={ActionProvider}
          messageParser={MessageParser}
        />
      </div>
    </div>
  );
}

export default App;
