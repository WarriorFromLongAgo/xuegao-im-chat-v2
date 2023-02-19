import http from "@/common/axios2/index";
import { Result } from "@/common/axios2/Result";

const idCenterNextIdHttp = async (): Promise<string> => {
  const result: Result<string> = await http.post<null, string>(
    "/idCenter/nextId"
  );
  // console.log("listChatInfoHttp result ", JSON.stringify(result));
  const { data: id } = result;
  // console.log("listChatInfoHttp chatInfoList ", JSON.stringify(chatInfoList));
  return id;
};

export { idCenterNextIdHttp };
