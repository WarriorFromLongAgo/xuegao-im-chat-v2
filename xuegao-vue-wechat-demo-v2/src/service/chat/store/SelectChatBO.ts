import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { SysUserBO } from "@/model/BO/SysUserBO";
import { GroupInfoDO } from "@/model/DO/GroupInfoDO";
import { FriendUserDO } from "@/model/DO/FriendUserDO";
import { GroupUserDO } from "@/model/DO/GroupUserDO";
import { reactive, readonly } from "vue";
import { isEmpty } from "@/common/ObjectUtil";

export { SelectChatBO, createSelectChat, createSelectChatMethod };

interface SelectChatBO {
  // 1000 私聊，1001 群聊
  chatType: ChatMsgTypeEnum;
  // 私聊的时候，对方的详细信息
  friendInfo?: SysUserBO;
  // 私聊的时候，人和人的关系
  friendUser?: FriendUserDO;
  // 群聊的时候，群的详细信息
  groupInfo?: GroupInfoDO;
  // 私聊的时候，人和群的关系
  groupUser?: GroupUserDO;
}

const selectChat: SelectChatBO = {
  chatType: ChatMsgTypeEnum.OneToOne,
};

function getSelectChat() {
  return selectChat;
}

function getChatType() {
  return selectChat.chatType;
}

function getFriendInfo() {
  return selectChat.friendInfo;
}

function getFriendUser() {
  return selectChat.friendUser;
}

function getGroupInfo() {
  return selectChat.groupInfo;
}

function getGroupUser() {
  return selectChat.groupUser;
}

function updateByFriend(friendInfo: SysUserBO, friendUser: FriendUserDO) {
  if (isEmpty(friendInfo) || isEmpty(friendUser)) {
    throw new Error("保存朋友的信息异常");
  }
  selectChat.chatType = ChatMsgTypeEnum.OneToOne;
  selectChat.friendUser = friendUser;
  selectChat.friendInfo = friendInfo;
  selectChat.groupInfo = undefined;
  selectChat.groupUser = undefined;
}

function updateByGroup(groupInfo: GroupInfoDO, groupUser: GroupUserDO) {
  if (isEmpty(groupInfo) || isEmpty(groupUser)) {
    throw new Error("保存群组的信息异常");
  }
  selectChat.chatType = ChatMsgTypeEnum.ManyToMany;
  selectChat.friendUser = undefined;
  selectChat.friendInfo = undefined;
  selectChat.groupInfo = groupInfo;
  selectChat.groupUser = groupUser;
}

function createSelectChatMethod() {
  return {
    getSelectChat,
    getChatType,
    getFriendInfo,
    getFriendUser,
    getGroupInfo,
    getGroupUser,
    updateByFriend,
    updateByGroup,
  };
}

function createSelectChat() {
  readonly(reactive(selectChat));
}
