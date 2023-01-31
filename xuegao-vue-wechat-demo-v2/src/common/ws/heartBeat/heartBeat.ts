import HearBeatMessageBO from "@/common/ws/heartBeat/HearBeatMessageBO";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { useWsStore } from "@/common/ws/store/wsStore";

function hearBeat() {
  const heart: HearBeatMessageBO = {
    messageType: ChatMsgTypeEnum.HeartBeatPing,
    content: "ping",
  };

  // 30秒一次
  const interval = setInterval(() => {
    useWsStore().action.sendMsg(JSON.stringify(heart));
  }, 1000 * 10);

  console.log("hearBeat interval ", interval);
  return interval;
}

export default hearBeat;
