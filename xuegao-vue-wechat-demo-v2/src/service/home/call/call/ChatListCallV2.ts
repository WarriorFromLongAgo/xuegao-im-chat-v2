import http from "@/common/axios2/index";
import { Result } from "@/common/axios2/Result";
import { ChatInfo } from "@/model/BO/ChatInfo";

const listChatInfoHttp = async (): Promise<Array<ChatInfo>> => {
  const result: Result<Array<ChatInfo>> = await http.post<
    null,
    Array<ChatInfo>
  >("/chatInfo/listChatInfo");
  // console.log("listChatInfoHttp result ", JSON.stringify(result));
  const { data: chatInfoList } = result;
  // console.log("listChatInfoHttp data ", JSON.stringify(chatInfoList));
  chatInfoList.forEach((c) => {
    c.newMsgNum = c.newMsgNum ?? 0;
  });
  // console.log("listChatInfoHttp chatInfoList ", JSON.stringify(chatInfoList));
  return chatInfoList;
};

export { listChatInfoHttp };
