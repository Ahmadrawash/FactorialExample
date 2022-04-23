// MessageParser starter code
// class MessageParser {
//     constructor(actionProvider, state) {
//       this.actionProvider = actionProvider;
//       this.state = state;
//     }
class MessageParser {
    //used to update the internal state of the chatbot
    
    constructor(actionProvider) {
      this.actionProvider = actionProvider;
    }
  
    //user input is picked up an ran through here
    //We have to parse every message that comes through here. This can be complex or whatever fits our needs
    parse(message) {
      console.log(message)
      const lowercase = message.toLowerCase();

      if(lowercase.includes("hello", "sup")){
          this.actionProvider.greet();
      }
    }
  }
  
  export default MessageParser;