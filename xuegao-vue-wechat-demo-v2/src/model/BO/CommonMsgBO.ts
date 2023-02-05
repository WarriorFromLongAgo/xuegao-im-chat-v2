import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";

interface CommonMsgBO {
  /**
   * 消息类型，HeartBeatPong = 4
   */
  messageType: MsgSendTypeEnum;
  /**
   * 消息内容
   */
  content: string;
}

export default CommonMsgBO;
