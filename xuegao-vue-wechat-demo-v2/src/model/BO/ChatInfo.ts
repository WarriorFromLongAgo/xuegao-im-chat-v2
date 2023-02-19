import { FriendMessageDO } from "@/model/DO/FriendMessageDO";
import { GroupInfoDO } from "@/model/DO/GroupInfoDO";
import { GroupMessageDO } from "@/model/DO/GroupMessageDO";
import { getDate } from "@/common/time";
import { SysUserBO } from "@/model/BO/SysUserBO";
import {
  friendInfoDataOne,
  friendInfoDataThree,
  friendInfoDataTwo,
} from "@/model/temp/FriendInfoData";
import {
  friendMessageDataOne,
  friendMessageDataThree,
  friendMessageDataTwo,
} from "@/model/temp/FriendMessageData";
import { FriendUserDO } from "@/model/DO/FriendUserDO";
import { GroupUserDO } from "@/model/DO/GroupUserDO";
import {
  friendUserDataOne,
  friendUserDataThree,
  friendUserDataTwo,
} from "@/model/temp/FriendUserData";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";

const nowDate = getDate();

// 聊天会话 列表
interface ChatInfo {
  // 聊天在会话列表的位置
  index: number;

  // 新消息条数
  newMsgNum: number;
  // 最后的消息时间
  lastMsgTime: string;
  // 1000 私聊，1001 群聊
  chatType: MsgSendTypeEnum;
  // 私聊的时候，对方的详细信息
  friendInfo?: SysUserBO;
  // 私聊的时候，这里应该只存最后一条消息，这里面需要冗余对方的名字，id
  lastFriendMessage?: FriendMessageDO;
  // 私聊的时候，人和人的关系
  friendUser?: FriendUserDO;
  // 群聊的时候，群的详细信息
  groupInfo?: GroupInfoDO;
  // 群聊的时候，这里应该只存最后一条消息，这里面需要冗余群的名字，id
  lastGroupMessage?: GroupMessageDO;
  // 私聊的时候，人和群的关系
  groupUser?: GroupUserDO;
}

const chatInfoOne: ChatInfo = {
  index: 1,
  newMsgNum: 0,
  lastMsgTime: nowDate.toTimeString(),
  chatType: MsgSendTypeEnum.oneToOne,
  friendInfo: friendInfoDataOne,
  lastFriendMessage: friendMessageDataOne,
  friendUser: friendUserDataOne,
};

const chatInfoTwo: ChatInfo = {
  index: 2,
  newMsgNum: 98,
  lastMsgTime: nowDate.toTimeString(),
  chatType: MsgSendTypeEnum.oneToOne,
  friendInfo: friendInfoDataTwo,
  lastFriendMessage: friendMessageDataTwo,
  friendUser: friendUserDataTwo,
};

const chatInfoThree: ChatInfo = {
  index: 3,
  newMsgNum: 100,
  lastMsgTime: nowDate.toTimeString(),
  chatType: MsgSendTypeEnum.oneToOne,
  friendInfo: friendInfoDataThree,
  lastFriendMessage: friendMessageDataThree,
  friendUser: friendUserDataThree,
};

function getChatInfoList(): Array<ChatInfo> {
  const chatInfoV2List: Array<ChatInfo> = new Array<ChatInfo>();
  chatInfoV2List.push(chatInfoOne);
  chatInfoV2List.push(chatInfoTwo);
  chatInfoV2List.push(chatInfoThree);
  return chatInfoV2List;
}

export { ChatInfo, getChatInfoList, chatInfoOne };
