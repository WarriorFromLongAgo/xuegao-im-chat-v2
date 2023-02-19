import { reactive } from "vue";
import { ChatInfo } from "@/model/BO/ChatInfo";

export { createState };

const chatList: Array<ChatInfo> = [];

function createState(): Array<ChatInfo> {
  return reactive(chatList);
}
