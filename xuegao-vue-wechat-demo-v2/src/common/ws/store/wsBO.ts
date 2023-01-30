import { reactive } from "vue";
import hearBeatMessageBO from "@/model/BO/HearBeatMessageBO";
import { GroupMessageDO } from "@/model/DO/GroupMessageDO";
import { FriendMessageDO } from "@/model/DO/FriendMessageDO";

interface WsBO {
  // data: hearBeatMessageBO | FriendMessageDO | GroupMessageDO | object;
  webSocket: null | WebSocket;
}

const ws: WsBO = {
  // data: {},
  webSocket: null,
};

function createState() {
  // console.log("WsBO createState");
  return reactive(ws);
}

export { WsBO, createState };
