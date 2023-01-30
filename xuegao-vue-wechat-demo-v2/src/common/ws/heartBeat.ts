import HearBeatMessageBO from "@/model/BO/HearBeatMessageBO";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { useWsStore } from "@/common/ws/store/wsStore";

function hearBeat() {
  const heart: HearBeatMessageBO = {
    messageType: ChatMsgTypeEnum.HeartBeatPing,
    content: "ping",
  };

  // 30秒一次
  setInterval(() => {
    useWsStore().action.sendMsg(JSON.stringify(heart));
  }, 1000 * 30);
}

export default hearBeat;
