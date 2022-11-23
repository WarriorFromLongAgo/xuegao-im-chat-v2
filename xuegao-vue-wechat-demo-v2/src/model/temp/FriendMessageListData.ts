import { FriendMessageDO } from "@/model/DO/FriendMessageDO";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { AckTypeEnum } from "@/model/Enum/AckTypeEnum";
import { MsgDataStatusEnum } from "@/model/Enum/MsgDataStatusEnum";
import { getDate } from "@/common/time";

const nowTimeOne = getDate();
const nowTimeTwo = getDate();
const nowTimeThree = getDate();

const friendMessageList1To1List = [];
const date = getDate();
date.setTime(nowTimeOne.setSeconds(nowTimeOne.getSeconds() - 2));
const friendMessageList1To1_One: FriendMessageDO = {
  id: "1",
  userId: "1",
  friendId: "1",
  messageType: ChatMsgTypeEnum.Text,
  content: "我已经通过你的好友请求，现在可以开始聊天了",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};
const friendMessageList1To1_Two: FriendMessageDO = {
  id: "2",
  userId: "1",
  friendId: "1",
  messageType: ChatMsgTypeEnum.Text,
  content: "hello 我叫偷懒的机器人",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};
const friendMessageList1To1_Three: FriendMessageDO = {
  id: "3",
  userId: "1",
  friendId: "1",
  messageType: ChatMsgTypeEnum.Text,
  content: "hello 我叫偷懒的机器人",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};
friendMessageList1To1List.push(
  friendMessageList1To1_One,
  friendMessageList1To1_Two,
  friendMessageList1To1_Three
);

const friendMessageList1To2List = [];
date.setTime(nowTimeTwo.setSeconds(nowTimeTwo.getSeconds() - 2));
const friendMessageList1To2_One: FriendMessageDO = {
  id: "1",
  userId: "1",
  friendId: "2",
  messageType: ChatMsgTypeEnum.Text,
  content: "我已经通过你的好友请求，现在可以开始聊天了",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};
const friendMessageList1To2_Two: FriendMessageDO = {
  id: "2",
  userId: "1",
  friendId: "2",
  messageType: ChatMsgTypeEnum.Text,
  content: "hello 我叫偷懒的机器人",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};
const friendMessageList1To2_Three: FriendMessageDO = {
  id: "3",
  userId: "2",
  friendId: "1",
  messageType: ChatMsgTypeEnum.Text,
  content: "hello 我叫偷懒的雪糕",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};
friendMessageList1To2List.push(
  friendMessageList1To2_One,
  friendMessageList1To2_Two,
  friendMessageList1To2_Three
);

const friendMessageList1To3List = [];
date.setTime(nowTimeThree.setSeconds(nowTimeThree.getSeconds() - 2));
const friendMessageList1To3_One: FriendMessageDO = {
  id: "1",
  userId: "1",
  friendId: "3",
  messageType: ChatMsgTypeEnum.Text,
  content: "我已经通过你的好友请求，现在可以开始聊天了",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};
const friendMessageList1To3_Two: FriendMessageDO = {
  id: "2",
  userId: "1",
  friendId: "3",
  messageType: ChatMsgTypeEnum.Text,
  content: "hello 我叫偷懒的机器人",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};
const friendMessageList1To3_Three: FriendMessageDO = {
  id: "3",
  userId: "3",
  friendId: "1",
  messageType: ChatMsgTypeEnum.Text,
  content: "hello 我叫满足的雪糕",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
};
friendMessageList1To3List.push(
  friendMessageList1To3_One,
  friendMessageList1To3_Two,
  friendMessageList1To3_Three
);

export {
  friendMessageList1To1List,
  friendMessageList1To2List,
  friendMessageList1To3List,
};
