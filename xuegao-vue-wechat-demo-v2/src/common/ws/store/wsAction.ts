import { WsBO } from "@/common/ws/store/wsBO";
import hearBeat from "@/common/ws/heartBeat/heartBeat";
import CommonMsgBO from "@/model/BO/CommonMsgBO";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";
import { useWsStore } from "@/common/ws/store/wsStore";
import { SysUserDO } from "@/model/DO/SysUserDO";
import { SysUserBO } from "@/model/BO/SysUserBO";

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
    if (webSocket === null) {
      throw Error("webSocket 链接为空，发送失败");
    }
    console.log("sendMsg 客户端发送消息 = ", message);
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
    stopHeartBeat(state);
    const closeWs: CommonMsgBO = {
      messageType: MsgSendTypeEnum.wsClose,
      content: "断开 websocket",
    };
    useWsStore().action.sendMsg(JSON.stringify(closeWs));
    state.webSocket = null;
    webSocket.close();
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

function bindSession(state: WsBO) {
  return (userByToken: SysUserBO) => {
    const session: CommonMsgBO = {
      messageType: MsgSendTypeEnum.bingSession,
      content: JSON.stringify(userByToken),
    };
    useWsStore().action.sendMsg(JSON.stringify(session));
  };
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
    bindSession: bindSession(state),
  };
}
