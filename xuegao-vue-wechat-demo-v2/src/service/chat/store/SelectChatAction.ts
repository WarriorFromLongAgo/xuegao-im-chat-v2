import { isEmpty } from "@/common/ObjectUtil";
import { SelectChatBO } from "@/service/chat/store/SelectChatBO";
import { ChatInfo } from "@/model/BO/ChatInfo";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";

export { createAction };

function getChatType(state: SelectChatBO) {
  return () => {
    return state.chatType;
  };
}

function getFriendInfo(state: SelectChatBO) {
  return () => {
    return state.friendInfo;
  };
}

function getFriendUser(state: SelectChatBO) {
  return () => {
    return state.friendUser;
  };
}

function getGroupInfo(state: SelectChatBO) {
  return () => {
    return state.groupInfo;
  };
}

function getGroupUser(state: SelectChatBO) {
  return () => {
    return state.groupUser;
  };
}

function updateSelectChat(state: SelectChatBO) {
  return (chatInfo: ChatInfo) => {
    if (isEmpty(chatInfo)) {
      throw new Error("入参不能为空");
    }
    const selectChatType = chatInfo.chatType;
    state.chatType = selectChatType;

    if (MsgSendTypeEnum.OneToOne === selectChatType) {
      state.friendInfo = chatInfo.friendInfo;
      state.friendUser = chatInfo.friendUser;
      state.groupInfo = undefined;
      state.groupUser = undefined;
    }
    if (MsgSendTypeEnum.ManyToMany === selectChatType) {
      state.friendUser = undefined;
      state.friendInfo = undefined;
      state.groupInfo = chatInfo.groupInfo;
      state.groupUser = chatInfo.groupUser;
    }
  };
}

function clearSelectChat(state: SelectChatBO) {
  return () => {
    state.chatType = undefined;
    state.friendInfo = undefined;
    state.friendUser = undefined;
    state.groupInfo = undefined;
    state.groupUser = undefined;
  };
}

function getSelectChat(state: SelectChatBO) {
  return () => {
    return state;
  };
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
