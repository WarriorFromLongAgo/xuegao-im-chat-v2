import { WsBO } from "@/common/ws/store/wsBO";
import hearBeat from "@/common/ws/heartBeat/heartBeat";

function initWebSocket(state: WsBO) {
  return (ws: WebSocket) => {
    // console.log("initWebSocket ws 1 ", JSON.stringify(ws));
    // console.log("initWebSocket ws 2 ", ws);
    state.webSocket = ws;
    // console.log("initWebSocket state ", state);
    startHeartBeat(state);
  };
}

function getWebSocket(state: WsBO): () => WebSocket {
  return () => {
    const webSocket = state.webSocket;
    // console.log("getWebSocket ", webSocket);
    if (webSocket === null) {
      throw Error("dada");
    }
    return webSocket;
  };
}

function sendMsg(state: WsBO) {
  return (message: string) => {
    const webSocket = state.webSocket;
    console.log("sendMsg ", webSocket);
    // 如果链接已经断开了，就不要再发送了
    if (webSocket !== null && webSocket?.CLOSED === webSocket?.readyState) {
      return;
    }
    console.log("message ", message);
    if (webSocket === null) {
      throw Error("dada");
    }
    webSocket.send(message);
  };
}

function closeWs(state: WsBO) {
  return () => {
    const webSocket = state.webSocket;
    console.log("closeWs ", webSocket);
    if (webSocket === null) {
      console.log("closeWs webSocket is null ");
      return;
    }
    // webSocket.close();
    stopHeartBeat(state);
  };
}

function startHeartBeat(state: WsBO) {
  const interval = hearBeat();
  console.log("startHeartBeat ", interval);
  state.interval = interval;
}

function stopHeartBeat(state: WsBO) {
  console.log("stopHeartBeat ", state.interval);
  if (state.interval === null) {
    return;
  }
  clearInterval(state.interval);
  console.log("clearInterval ", state.interval);
}

/**
 * 创建Action
 */
export function createAction(state: WsBO) {
  return {
    initWebSocket: initWebSocket(state),
    getWebSocket: getWebSocket(state),
    sendMsg: sendMsg(state),
    closeWs: closeWs(state),
  };
}
