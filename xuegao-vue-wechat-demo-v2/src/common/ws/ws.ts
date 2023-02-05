import { wsUrl } from "@/common/config/config";
import { useWsStore } from "@/common/ws/store/wsStore";
import CommonMsgBO from "@/model/BO/CommonMsgBO";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";
import { useLoginStore } from "@/service/login/store/LoginInfoStore";

function initWebSocket() {
  const ws: WebSocket = new WebSocket(wsUrl);

  // 第一次客户端，链接服务端，就会调用这里
  ws.onopen = function wsOnOpen(ev: Event) {
    console.log("wsOnMsg 收到服务端的开启返回 = ", ev);
    sendFirst();
    bindSession();
  };

  // 每次收到服务端的返回，都会调用这里
  ws.onmessage = function wsOnMsg(ev: MessageEvent) {
    console.log("wsOnMsg 收到服务端的消息返回 = ", ev);
  };

  ws.onerror = function wsOnError(ev: Event) {
    console.log("wsOnError 收到服务端的异常 = ", ev);
  };

  // 服务端主动触发
  ws.onclose = function wsOnClose(ev: CloseEvent) {
    console.log("wsOnClose 收到服务端的关闭请求 = ", ev);
    useWsStore().action.closeWs();
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

function bindSession() {
  const session: CommonMsgBO = {
    messageType: MsgSendTypeEnum.bingSession,
    content: JSON.stringify(useLoginStore().action.getLoginSysUser()),
  };
  useWsStore().action.sendMsg(JSON.stringify(session));
}

export default initWebSocket;
