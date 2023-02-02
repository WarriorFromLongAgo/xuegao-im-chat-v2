import HearBeatMessageBO from "@/model/BO/HearBeatMessageBO";
import { useWsStore } from "@/common/ws/store/wsStore";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";

function hearBeat() {
  const heart: HearBeatMessageBO = {
    messageType: MsgSendTypeEnum.HeartBeatPing,
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
