import { reactive } from "vue";

interface WsBO {
  // data: hearBeatMessageBO | FriendMessageDO | GroupMessageDO | object;
  webSocket: null | WebSocket;
  interval: null | number;
}

const ws: WsBO = {
  // data: {},
  webSocket: null,
  interval: null,
};

function createState() {
  // console.log("WsBO createState");
  return reactive(ws);
}

export { WsBO, createState };
