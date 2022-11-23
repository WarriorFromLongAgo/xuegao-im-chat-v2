import { SysUserBO } from "@/model/BO/SysUserBO";
import { FriendUserDO } from "@/model/DO/FriendUserDO";
import { isEmpty } from "@/common/ObjectUtil";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { GroupInfoDO } from "@/model/DO/GroupInfoDO";
import { GroupUserDO } from "@/model/DO/GroupUserDO";
import { SelectChatBO } from "@/service/chat/store/SelectChatBO";

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

function updateByFriend(
  state: SelectChatBO,
  friendInfo: SysUserBO,
  friendUser: FriendUserDO
) {
  if (isEmpty(friendInfo) || isEmpty(friendUser)) {
    throw new Error("保存朋友的信息异常");
  }

  return (friendInfo: SysUserBO, friendUser: FriendUserDO) => {
    state.chatType = chatType;
  };

  state.chatType = ChatMsgTypeEnum.OneToOne;
  state.friendUser = friendUser;
  state.friendInfo = friendInfo;
  state.groupInfo = undefined;
  state.groupUser = undefined;
}

function updateByGroup(
  state: SelectChatBO,
  groupInfo: GroupInfoDO,
  groupUser: GroupUserDO
) {
  if (isEmpty(groupInfo) || isEmpty(groupUser)) {
    throw new Error("保存群组的信息异常");
  }
  state.chatType = ChatMsgTypeEnum.ManyToMany;
  state.friendUser = undefined;
  state.friendInfo = undefined;
  state.groupInfo = groupInfo;
  state.groupUser = groupUser;
}

function updateChatType(state: SelectChatBO) {
  return (chatType: ChatMsgTypeEnum) => {
    state.chatType = chatType;
  };
}

function createAction(state: SelectChatBO) {
  return {
    getChatType: getChatType(state),
    getFriendInfo: getFriendInfo(state),
    getFriendUser: getFriendUser(state),
    getGroupInfo: getGroupInfo(state),
    getGroupUser: getGroupUser(state),
    updateByFriend: updateByFriend(state),
    updateByGroup: updateByGroup(state),
    updateChatType: updateChatType(state),
  };
}
