import { AckTypeEnum } from "@/model/Enum/AckTypeEnum";
import { MsgDataStatusEnum } from "@/model/Enum/MsgDataStatusEnum";
import { getDate } from "@/common/time";
import { FriendMessageBO } from "@/model/BO/FriendMessageBO";
import { MsgTypeEnum } from "@/model/Enum/MsgTypeEnum";

const nowTimeOne = getDate();
const nowTimeTwo = getDate();
const nowTimeThree = getDate();

const friendMessageList1To1List: Array<FriendMessageBO> =
  new Array<FriendMessageBO>();
const date = getDate();
date.setTime(nowTimeOne.setSeconds(nowTimeOne.getSeconds() - 2));
const friendMessageList1To1_One: FriendMessageBO = {
  id: "1",
  userId: "1",
  friendId: "1",
  messageType: MsgTypeEnum.Text,
  content: "friendId 1 我已经通过你的好友请求，现在可以开始聊天了",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
};
const friendMessageList1To1_Two: FriendMessageBO = {
  id: "2",
  userId: "1",
  friendId: "1",
  messageType: MsgTypeEnum.Text,
  content: "friendId 1  hello 我叫偷懒的机器人",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
};
const friendMessageList1To1_Three: FriendMessageBO = {
  id: "3",
  userId: "1",
  friendId: "1",
  messageType: MsgTypeEnum.Text,
  content: "friendId 1 hello 我叫偷懒的机器人",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
};
friendMessageList1To1List.push(
  friendMessageList1To1_One,
  friendMessageList1To1_Two,
  friendMessageList1To1_Three
);

const friendMessageList1To2List: Array<FriendMessageBO> =
  new Array<FriendMessageBO>();
date.setTime(nowTimeTwo.setSeconds(nowTimeTwo.getSeconds() - 2));
const friendMessageList1To2_One: FriendMessageBO = {
  id: "1",
  userId: "1",
  friendId: "2",
  messageType: MsgTypeEnum.Text,
  content: "friendId 2 我已经通过你的好友请求，现在可以开始聊天了",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
};
const friendMessageList1To2_Two: FriendMessageBO = {
  id: "2",
  userId: "1",
  friendId: "2",
  messageType: MsgTypeEnum.Text,
  content: "friendId 2 hello 我叫偷懒的机器人",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
};
const friendMessageList1To2_Three: FriendMessageBO = {
  id: "3",
  userId: "2",
  friendId: "1",
  messageType: MsgTypeEnum.Text,
  content: "friendId 2 ello 我叫偷懒的雪糕",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
};
friendMessageList1To2List.push(
  friendMessageList1To2_One,
  friendMessageList1To2_Two,
  friendMessageList1To2_Three
);

const friendMessageList1To3List: Array<FriendMessageBO> =
  new Array<FriendMessageBO>();
date.setTime(nowTimeThree.setSeconds(nowTimeThree.getSeconds() - 2));
const friendMessageList1To3_One: FriendMessageBO = {
  id: "1",
  userId: "1",
  friendId: "3",
  messageType: MsgTypeEnum.Text,
  content: "friendId 3 我已经通过你的好友请求，现在可以开始聊天了",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
};
const friendMessageList1To3_Two: FriendMessageBO = {
  id: "2",
  userId: "1",
  friendId: "3",
  messageType: MsgTypeEnum.Text,
  content: "friendId 3 hello 我叫偷懒的机器人",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
};
const friendMessageList1To3_Three: FriendMessageBO = {
  id: "3",
  userId: "3",
  friendId: "1",
  messageType: MsgTypeEnum.Text,
  content: "friendId 3 hello 我叫满足的雪糕",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
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
