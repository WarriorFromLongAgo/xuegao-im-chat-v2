import { GenericModel } from "@/model/DO/GenericModel";
import { MsgNotDisturbEnum } from "@/model/Enum/MsgNotDisturbEnum";

/**
 * 群里面的每个人，特殊信息设置
 */
interface GroupUserDO extends GenericModel {
  /**
   * 群id
   */
  groupId: string;
  /**
   * 用户id
   */
  userId: string;
  /**
   * 群里面，每个人设置展示自己在本群的昵称
   */
  userNickname: string;
  /**
   * 群备注，方便自己知道这个群的用处
   */
  groupNote: string;
  /**
   * 免打扰，10正常，20免打扰
   */
  notDisturb: MsgNotDisturbEnum;
}

export { GroupUserDO };
