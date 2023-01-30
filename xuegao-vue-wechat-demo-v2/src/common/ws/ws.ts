import { wsUrl } from "@/common/config/config";
import hearBeat from "@/common/ws/heartBeat";
import { useWsStore } from "@/common/ws/store/wsStore";

function initWebSocket() {
  const ws: WebSocket = new WebSocket(wsUrl);

  // 第一次客户端，链接服务端，就会调用这里
  ws.onopen = function wsOnOpen(ev: Event) {
    console.log("wsOnOpen ev", ev);
    sendFirst();
    hearBeat();
  };

  // 每次收到服务端的返回，都会调用这里
  ws.onmessage = function wsOnMsg(ev: MessageEvent) {
    console.log("wsOnMsg ev", ev);
  };

  ws.onerror = function wsOnError(ev: Event) {
    console.log("wsOnError ev", ev);
  };

  ws.onclose = function wsOnClose(ev: CloseEvent) {
    console.log("wsOnClose ev", ev);
  };

  console.log("ws 1 = ", ws);
  useWsStore().action.initWebSocket(ws);
  // console.log("ws 2 = ", ws);
}

function sendFirst() {
  const webSocket = useWsStore().action.getWebSocket();
  webSocket.send("ws.onopen 我们的链接已经打开了");
}

export default initWebSocket;
