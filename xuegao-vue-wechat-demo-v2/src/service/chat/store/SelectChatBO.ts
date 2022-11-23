import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { SysUserBO } from "@/model/BO/SysUserBO";
import { GroupInfoDO } from "@/model/DO/GroupInfoDO";
import { FriendUserDO } from "@/model/DO/FriendUserDO";
import { GroupUserDO } from "@/model/DO/GroupUserDO";
import { reactive } from "vue";

export { SelectChatBO, createState };

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

function createState(): SelectChatBO {
  return reactive(selectChat);
}
