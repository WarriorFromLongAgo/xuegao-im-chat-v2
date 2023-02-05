import { SelectChatMessageBO } from "@/service/chat/store/SelectChatMessageBO";
import { isEmpty } from "@/common/ObjectUtil";
import { FriendMessageDO } from "@/model/DO/FriendMessageDO";
import { GroupMessageDO } from "@/model/DO/GroupMessageDO";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";

export { createAction };

function createAction(state: SelectChatMessageBO) {
  return {
    updateSelectChatMessage: updateSelectChatMessage(state),
    clearSelectChatMessage: clearSelectChatMessage(state),
    getFriendMessageList: getFriendMessageList(state),
    getGroupMessageList: getGroupMessageList(state),
    getState: getState(state),
  };
}

function updateSelectChatMessage(state: SelectChatMessageBO) {
  return (selectChatMessage: SelectChatMessageBO) => {
    if (isEmpty(selectChatMessage)) {
      throw new Error("入参不能为空");
    }
    if (isEmpty(selectChatMessage.chatType)) {
      throw new Error("入参消息类型不能为空");
    }
    const selectChatType = selectChatMessage.chatType;
    state.chatType = selectChatType;

    if (MsgSendTypeEnum.oneToOne === selectChatType) {
      state.friendMessageList = selectChatMessage.friendMessageList;
      state.groupMessageList = undefined;
    }
    if (MsgSendTypeEnum.manyToMany === selectChatType) {
      state.friendMessageList = undefined;
      state.groupMessageList = selectChatMessage.groupMessageList;
    }
  };
}

function clearSelectChatMessage(state: SelectChatMessageBO) {
  return () => {
    state.chatType = undefined;
    state.friendMessageList = undefined;
    state.groupMessageList = undefined;
  };
}

function getFriendMessageList(state: SelectChatMessageBO) {
  return () => {
    return state.friendMessageList;
  };
}

function getGroupMessageList(state: SelectChatMessageBO) {
  return () => {
    return state.groupMessageList;
  };
}

function getState(state: SelectChatMessageBO) {
  return (): Array<GroupMessageDO> | Array<FriendMessageDO> | undefined => {
    const selectChatType = state.chatType;
    if (MsgSendTypeEnum.oneToOne === selectChatType) {
      return state.friendMessageList;
    }
    if (MsgSendTypeEnum.manyToMany === selectChatType) {
      return state.groupMessageList;
    }
  };
}
