import { isEmpty } from "@/common/ObjectUtil";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { SelectChatBO } from "@/service/chat/store/SelectChatBO";
import { ChatInfo } from "@/model/BO/ChatInfo";

export { createAction };

function getChatType(state: SelectChatBO) {
  return state.chatType;
}

function getFriendInfo(state: SelectChatBO) {
  return state.friendInfo;
}

function getFriendUser(state: SelectChatBO) {
  return state.friendUser;
}

function getGroupInfo(state: SelectChatBO) {
  return state.groupInfo;
}

function getGroupUser(state: SelectChatBO) {
  return state.groupUser;
}

function updateSelectChat(state: SelectChatBO) {
  return (chatInfo: ChatInfo) => {
    console.log(" updateSelectChat 1 ", JSON.stringify(state));
    if (isEmpty(chatInfo)) {
      throw new Error("入参不能为空");
    }
    const selectChatType = chatInfo.chatType;
    state.chatType = selectChatType;

    if (ChatMsgTypeEnum.OneToOne === selectChatType) {
      state.friendInfo = chatInfo.friendInfo;
      state.friendUser = chatInfo.friendUser;
      state.groupInfo = undefined;
      state.groupUser = undefined;
    }
    if (ChatMsgTypeEnum.ManyToMany === selectChatType) {
      state.friendUser = undefined;
      state.friendInfo = undefined;
      state.groupInfo = chatInfo.groupInfo;
      state.groupUser = chatInfo.groupUser;
    }
    console.log(" updateSelectChat 2 ", JSON.stringify(state));
  };
}

function clearSelectChat(state: SelectChatBO) {
  console.log("  clearSelectChat 1 ", JSON.stringify(state));
  state.chatType = undefined;
  state.friendInfo = undefined;
  state.friendUser = undefined;
  state.groupInfo = undefined;
  state.groupUser = undefined;
  console.log("  clearSelectChat 2 ", JSON.stringify(state));
  return state;
}

function getSelectChat(state: SelectChatBO) {
  return state;
}

function createAction(state: SelectChatBO) {
  return {
    getSelectChat: getSelectChat(state),
    getChatType: getChatType(state),
    getFriendInfo: getFriendInfo(state),
    getFriendUser: getFriendUser(state),
    getGroupInfo: getGroupInfo(state),
    getGroupUser: getGroupUser(state),
    updateSelectChat: updateSelectChat(state),
    clearSelectChat: clearSelectChat(state),
  };
}
