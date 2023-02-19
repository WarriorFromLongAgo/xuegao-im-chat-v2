import { ChatInfo } from "@/model/BO/ChatInfo";

export { createAction };

function updateChatInfoList(state: Array<ChatInfo>) {
  return (inputList: Array<ChatInfo>) => {
    state = [];
    console.log(" updateChatInfoList 1 ", state);
    console.log(" updateChatInfoList 2 ", inputList);
    inputList.forEach((arr) => {
      state.push(arr);
    });
    console.log(" updateChatInfoList 100 ", state);
  };
}

function chatInfoList(state: Array<ChatInfo>) {
  return () => {
    console.log(" createAction chatInfoList ");
    return state;
  };
}

function createAction(state: Array<ChatInfo>) {
  return {
    updateChatInfoList: updateChatInfoList(state),
    chatInfoList: chatInfoList(state),
  };
}
