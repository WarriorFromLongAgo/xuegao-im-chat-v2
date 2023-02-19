import { Result } from "@/common/axios2/Result";
import http from "@/common/axios2";
import { FriendMessageDO } from "@/model/DO/FriendMessageDO";
import { FriendMessageBO } from "@/model/BO/FriendMessageBO";
import { GenericModelDTO } from "@/model/DO/GenericModelDTO";

const listSelectChatMsgListHttp = async (
  input: string
): Promise<Array<FriendMessageBO>> => {
  type tempFriendMessageDO = Pick<FriendMessageDO, "friendId">;
  type tempGenericModelDTO = Pick<GenericModelDTO<tempFriendMessageDO>, "vo">;

  const friendMsg: tempFriendMessageDO = {
    friendId: input,
  };

  const request: tempGenericModelDTO = {
    vo: friendMsg,
  };

  const result: Result<Array<FriendMessageBO>> = await http.post<
    tempGenericModelDTO,
    Array<FriendMessageBO>
  >("/friendMessage/list", request);
  // console.log("listChatInfoHttp result ", JSON.stringify(result));
  const { data: friendMessageList } = result;
  // console.log("listChatInfoHttp data ", JSON.stringify(chatInfoList));
  // chatInfoList.forEach((c) => {
  //   c.newMsgNum = c.newMsgNum ?? 0;
  // });
  console.log("listSelectChatMsgListHttp ", JSON.stringify(friendMessageList));
  return friendMessageList;
};

export { listSelectChatMsgListHttp };
