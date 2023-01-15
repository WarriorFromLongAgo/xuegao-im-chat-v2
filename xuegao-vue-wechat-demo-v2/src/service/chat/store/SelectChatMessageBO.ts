import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { reactive } from "vue";
import { GroupMessageDO } from "@/model/DO/GroupMessageDO";
import { FriendMessageBO } from "@/model/BO/FriendMessageBO";

export { SelectChatMessageBO, createState };

interface SelectChatMessageBO {
  // 1000 私聊，1001 群聊
  chatType?: ChatMsgTypeEnum;
  // 私聊聊天详细记录
  friendMessageList?: Array<FriendMessageBO>;
  // 群聊聊天详细记录
  groupMessageList?: Array<GroupMessageDO>;
}

const selectChat: SelectChatMessageBO = {};

function createState(): SelectChatMessageBO {
  return reactive(selectChat);
}
