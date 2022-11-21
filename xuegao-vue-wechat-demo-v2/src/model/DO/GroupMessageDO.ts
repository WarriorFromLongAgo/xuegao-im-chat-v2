import { GenericModel } from "@/model/DO/GenericModel";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { AckTypeEnum } from "@/model/Enum/AckTypeEnum";
import { MsgDataStatusEnum } from "@/model/Enum/MsgDataStatusEnum";

/**
 * 群消息
 */
interface GroupMessageDO extends GenericModel {
  /**
   * 群id
   */
  groupId: string;
  /**
   * 发送人id
   */
  userId: string;
  /**
   * 群id
   */
  messageType: ChatMsgTypeEnum;
  /**
   * 消息内容
   */
  content: string;
  /**
   * 消息是否送达10已送达，20未送达
   */
  ackType: AckTypeEnum;
  /**
   * 消息状态，10正常，20撤回
   */
  dataStatus: MsgDataStatusEnum;
}

export { GroupMessageDO };
