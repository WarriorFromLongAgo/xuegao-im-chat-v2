import { FriendInfo } from "@/model/FriendInfo";
import { MessageInfo } from "@/model/MessageInfo";

const now = new Date();

// 聊天会话 列表
interface ChatInfo {
  // 好像没有意义
  id: number;
  // 1 私聊，2 群聊
  type: number;
  // 聊天在会话列表的位置
  index: number;
  // 人id，或者是，群id
  chatId: string;
  // 会话的详细信息
  friendInfo: FriendInfo;
  // 新消息条数
  newMsgNum: 1;

  isShow: true;
  lastMsgTime: Date;
  messageList: Array<MessageInfo>;
}

const chatInfo1: ChatInfo = {
  id: 1,
  type: 1,
  index: 1,
  chatId: "99",
  friendInfo: {
    signature: "走别人的路，让别人无路可走",
    sex: 1,
    wxid: "12345",
    area: "奥林帕斯山",
    nickname: "机器人", //昵称2
    avatar: "/public/static/images/vue.jpg", //头像
    username: "99",
    remark: "偷懒的机器人", //备注
    notDisturb: true, // 免打扰
  },
  newMsgNum: 1, //新消息条数
  isShow: true,
  lastMsgTime: new Date(),
  messageList: [
    {
      id: 1,
      sendUid: "1",
      sendUName: "1",
      username: "99",
      msgType: 1,
      type: 1,
      content: "我会跟你聊聊天的哟",
      date: now,
      showTime: true,
      self: true,
    },
  ],
};

function getChatInfoList(): Array<ChatInfo> {
  const chatInfoList: Array<ChatInfo> = new Array<ChatInfo>();

  chatInfoList.push(chatInfo1);
  console.log(" getChatInfoList ");
  return chatInfoList;
}

export { ChatInfo, getChatInfoList };
