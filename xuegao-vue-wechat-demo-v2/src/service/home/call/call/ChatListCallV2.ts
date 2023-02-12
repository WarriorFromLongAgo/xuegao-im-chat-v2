import http from "@/common/axios2/index";
import { Result } from "@/common/axios2/Result";
import { ChatInfo } from "@/model/BO/ChatInfo";

const listChatInfoHttp = async () => {
  const result: Result<Array<ChatInfo>> = await http.post<
    null,
    Array<ChatInfo>
  >("/friendUser/listChatInfo");
  // console.log("listChatInfoHttp result ", JSON.stringify(result));
  const { data: chatInfoList } = result;
  // console.log("listChatInfoHttp data ", JSON.stringify(chatInfoList));
  return chatInfoList;
};

export { listChatInfoHttp };
