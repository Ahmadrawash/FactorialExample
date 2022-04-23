// ActionProvider starter code
// class ActionProvider {
//     constructor(
//      createChatBotMessage,
//      setStateFunc,
//      createClientMessage,
//      stateRef,
//      createCustomMessage,
//      ...rest
//    ) {
//      this.createChatBotMessage = createChatBotMessage;
//      this.setState = setStateFunc;
//      this.createClientMessage = createClientMessage;
//      this.stateRef = stateRef;
//      this.createCustomMessage = createCustomMessage;
//    }
//  }

import { render } from "@testing-library/react";

class ActionProvider {
  //used to update the internal state of the chatbot
  constructor(createChatBotMessage, setStateFunc) {
    this.createChatBotMessage = createChatBotMessage;
    this.setState = setStateFunc;
  }

  greet = () => {
    //************* commented by me ************* */
    const message = this.createChatBotMessage("Hello Ahmad.");
    //now lets update the state with setState in the addCat fucntion below
    this.addMessageToState(message);
    
   
  };

  addMessageToState = (message) => {
    //preserving the previous state when we are updating
    this.setState((prevState) => ({
      ...prevState,
      messages: [...prevState.messages, message],
    }));
  };
}
export default ActionProvider;
