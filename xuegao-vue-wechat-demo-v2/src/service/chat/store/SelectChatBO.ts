import { SysUserBO } from "@/model/BO/SysUserBO";
import { GroupInfoDO } from "@/model/DO/GroupInfoDO";
import { FriendUserDO } from "@/model/DO/FriendUserDO";
import { GroupUserDO } from "@/model/DO/GroupUserDO";
import { reactive } from "vue";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";

export { SelectChatBO, createState };

interface SelectChatBO {
  // 1000 私聊，1001 群聊
  chatType?: MsgSendTypeEnum;
  // 私聊的时候，对方的详细信息
  friendInfo?: SysUserBO;
  // 私聊的时候，人和人的关系
  friendUser?: FriendUserDO;
  // 群聊的时候，群的详细信息
  groupInfo?: GroupInfoDO;
  // 私聊的时候，人和群的关系
  groupUser?: GroupUserDO;
}

const selectChat: SelectChatBO = {};

function createState(): SelectChatBO {
  return reactive(selectChat);
}
