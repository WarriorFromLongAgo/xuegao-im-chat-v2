import { AckTypeEnum } from "@/model/Enum/AckTypeEnum";
import { MsgDataStatusEnum } from "@/model/Enum/MsgDataStatusEnum";
import { getDate } from "@/common/time";
import { FriendMessageBO } from "@/model/BO/FriendMessageBO";
import { MsgTypeEnum } from "@/model/Enum/MsgTypeEnum";
import { friendInfoDataOne } from "@/model/temp/FriendInfoData";

const nowTimeOne = getDate();
const nowTimeTwo = getDate();
const nowTimeThree = getDate();

const date = getDate();
date.setTime(nowTimeOne.setSeconds(nowTimeOne.getSeconds() - 2));
const friendMessageDataOne: FriendMessageBO = {
  id: "1",
  userId: "2",
  friendId: "1",
  messageType: MsgTypeEnum.Text,
  content: "我会跟你聊聊天的哟11",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
  sysUserBO: friendInfoDataOne,
};

date.setTime(nowTimeTwo.setSeconds(nowTimeTwo.getSeconds() - 2));
const friendMessageDataTwo: FriendMessageBO = {
  id: "2",
  userId: "2",
  friendId: "1",
  messageType: MsgTypeEnum.Text,
  content: "我会跟你聊聊天的哟22",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
  sysUserBO: friendInfoDataOne,
};

date.setTime(nowTimeThree.setSeconds(nowTimeThree.getSeconds() - 2));
const friendMessageDataThree: FriendMessageBO = {
  id: "3",
  userId: "2",
  friendId: "1",
  messageType: MsgTypeEnum.Text,
  content: "我会跟你聊聊天的哟33",
  ackType: AckTypeEnum.ACK_YES,
  dataStatus: MsgDataStatusEnum.MSG_NORMAL,
  createdTime: date,
  mySelfFlag: false,
  showTime: false,
  sysUserBO: friendInfoDataOne,
};

export { friendMessageDataOne, friendMessageDataTwo, friendMessageDataThree };
