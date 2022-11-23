import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { FriendMessageDO } from "@/model/DO/FriendMessageDO";
import { SysUserDO } from "@/model/DO/SysUserDO";
import { GroupInfoDO } from "@/model/DO/GroupInfoDO";
import { GroupMessageDO } from "@/model/DO/GroupMessageDO";
import { getDate } from "@/common/time";

const nowDate = getDate();

// 聊天会话 列表
interface ChatInfoData {
  // 聊天在会话列表的位置
  index: number;
  // 新消息条数
  newMsgNum: number;
  // 最后的消息时间
  lastMsgTime: Date;
  // 1000 私聊，1001 群聊
  chatType: ChatMsgTypeEnum;
  // 私聊的时候，对方的详细信息
  friendInfo: SysUserDO;
  // 私聊的时候，这里应该只存最后一条消息，这里面需要冗余对方的名字，id
  lastFriendMessage: FriendMessageDO;
  // 群聊的时候，群的详细信息
  groupInfo: GroupInfoDO;
  // 消息的列表，这里应该只存最后一条消息，这里面需要冗余对方的名字，id
  lastGroupMessage: GroupMessageDO;
}

const chatInfoV2One: ChatInfoData = {
  index: 1,
  newMsgNum: 0,
  lastMsgTime: nowDate,
  chatType: ChatMsgTypeEnum.OneToOne,
  friendInfo:
};

const chatInfoV2Two: ChatInfoData = {
  index: 2,
};

const chatInfoV2Three: ChatInfoData = {
  index: 3,
};

function getChatInfoV2List(): Array<ChatInfoData> {
  const chatInfoV2List: Array<ChatInfoData> = new Array<ChatInfoData>();
  chatInfoV2List.push(chatInfoV2One);
  chatInfoV2List.push(chatInfoV2Two);
  chatInfoV2List.push(chatInfoV2Three);
  console.log(" getChatInfoV2List ");
  return chatInfoV2List;
}

export { ChatInfoData, getChatInfoV2List };
