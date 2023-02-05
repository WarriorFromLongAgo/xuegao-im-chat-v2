import { wsUrl } from "@/common/config/config";
import { useWsStore } from "@/common/ws/store/wsStore";
import CommonMsgBO from "@/model/BO/CommonMsgBO";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";

function initWebSocket() {
  const ws: WebSocket = new WebSocket(wsUrl);

  // 第一次客户端，链接服务端，就会调用这里
  ws.onopen = function wsOnOpen(ev: Event) {
    console.log("wsOnOpen ev", ev);
    sendFirst();
    // hearBeat();
  };

  // 每次收到服务端的返回，都会调用这里
  ws.onmessage = function wsOnMsg(ev: MessageEvent) {
    console.log("wsOnMsg ev", ev);
    const data = ev.data;
    console.log("wsOnMsg ", data);
  };

  ws.onerror = function wsOnError(ev: Event) {
    console.log("wsOnError ev", ev);
  };

  // 服务端主动触发
  ws.onclose = function wsOnClose(ev: CloseEvent) {
    console.log("wsOnClose ev", ev);
  };

  console.log("ws 1 = ", ws);
  useWsStore().action.initWebSocket(ws);
  // console.log("ws 2 = ", ws);
}

function sendFirst() {
  const closeWs: CommonMsgBO = {
    messageType: MsgSendTypeEnum.wsOpen,
    content: "链接 websocket",
  };
  useWsStore().action.sendMsg(JSON.stringify(closeWs));
}

export default initWebSocket;
