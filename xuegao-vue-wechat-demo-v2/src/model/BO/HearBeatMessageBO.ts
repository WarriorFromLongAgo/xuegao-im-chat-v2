import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";

interface HearBeatMessageBO {
  /**
   * 消息类型，HeartBeatPong = 4
   */
  messageType: ChatMsgTypeEnum;
  /**
   * 消息内容
   */
  content: string;
}

export default HearBeatMessageBO;
