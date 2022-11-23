import { FriendMessageDO } from "@/model/DO/FriendMessageDO";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { AckTypeEnum } from "@/model/Enum/AckTypeEnum";
import { MsgDataStatusEnum } from "@/model/Enum/MsgDataStatusEnum";
import { getDate } from "@/common/time";

const nowTimeOne = getDate();
const nowTimeTwo = getDate();
const nowTimeThree = getDate();

const date = getDate();
date.setTime(nowTimeOne.setSeconds(nowTimeOne.getSeconds() - 2));
const friendMessageDataOne: FriendMessageDO = {
  id: "1",
  userId: "2",
  friendId: "1",
  messageType: ChatMsgTypeEnum.Text,
  content: "我会跟你聊聊天的哟11",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};

date.setTime(nowTimeTwo.setSeconds(nowTimeTwo.getSeconds() - 2));
const friendMessageDataTwo: FriendMessageDO = {
  id: "2",
  userId: "2",
  friendId: "1",
  messageType: ChatMsgTypeEnum.Text,
  content: "我会跟你聊聊天的哟22",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};

date.setTime(nowTimeThree.setSeconds(nowTimeThree.getSeconds() - 2));
const friendMessageDataThree: FriendMessageDO = {
  id: "3",
  userId: "2",
  friendId: "1",
  messageType: ChatMsgTypeEnum.Text,
  content: "我会跟你聊聊天的哟33",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};

export { friendMessageDataOne, friendMessageDataTwo, friendMessageDataThree };
