import CommonMsgBO from "@/model/BO/CommonMsgBO";
import { useWsStore } from "@/common/ws/store/wsStore";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";

function hearBeat() {
  const heart: CommonMsgBO = {
    messageType: MsgSendTypeEnum.heartBeatPing,
    content: "ping",
  };

  // 30秒一次
  const interval = setInterval(() => {
    useWsStore().action.sendMsg(JSON.stringify(heart));
  }, 1000 * 30);

  console.log("hearBeat interval ", interval);
  return interval;
}

export default hearBeat;
