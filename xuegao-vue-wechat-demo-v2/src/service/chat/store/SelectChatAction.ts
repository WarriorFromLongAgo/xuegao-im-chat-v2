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

// /**
//  * 修改，当前选择的为单聊
//  * */
// function updateByFriend(state: SelectChatBO) {
//   return (friendInfo: SysUserBO, friendUser: FriendUserDO) => {
//     if (isEmpty(friendInfo) || isEmpty(friendUser)) {
//       throw new Error("保存朋友的信息异常");
//     }
//     state.friendInfo = friendInfo;
//     state.friendUser = friendUser;
//     state.groupInfo = undefined;
//     state.groupUser = undefined;
//   };
// }
//
// /**
//  * 修改，当前选择的为群聊
//  * */
// function updateByGroup(state: SelectChatBO) {
//   return (groupInfo: GroupInfoDO, groupUser: GroupUserDO) => {
//     if (isEmpty(groupInfo) || isEmpty(groupUser)) {
//       throw new Error("保存群组的信息异常");
//     }
//     state.friendUser = undefined;
//     state.friendInfo = undefined;
//     state.groupInfo = groupInfo;
//     state.groupUser = groupUser;
//   };
// }

function updateSelectChat(state: SelectChatBO) {
  return (chatInfo: ChatInfo) => {
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
  };
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
    // updateByFriend: updateByFriend(state),
    // updateByGroup: updateByGroup(state),
    updateSelectChat: updateSelectChat(state),
  };
}
