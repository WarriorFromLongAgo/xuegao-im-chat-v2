import { GenericModel } from "@/model/DO/GenericModel";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { AckTypeEnum } from "@/model/Enum/AckTypeEnum";
import { MsgDataStatusEnum } from "@/model/Enum/MsgDataStatusEnum";

interface FriendMessageDO extends GenericModel {
  /**
   * 发送人id
   */
  userId: string;
  /**
   * 接收者id
   */
  friendId: string;
  /**
   * 消息类型，text，image，audio，video，
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

export { FriendMessageDO };
