import { FriendInfo } from "@/model/FriendInfo";
import { MessageInfo } from "@/model/MessageInfo";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";

const now = new Date();

// 聊天会话 列表
interface ChatInfo {
  // 好像没有意义，就是消息的主键，目前是单表，不是分库分表，，所以是无所谓的
  // 分库分表，就必须是分布式id了。不能直接递增
  id: number;
  // 1 私聊，2 群聊
  type: ChatMsgTypeEnum;
  // 聊天在会话列表的位置
  index: number;
  // 人id，或者是，群id，或者是其他的id
  // 就是会话的id
  chatId: string;
  // 会话的详细信息
  // 你打开的可能是一个私聊，或者是，群聊
  // 算了，根据type。拿取不同的字段吧，否则一个对象的字段太多了
  friendInfo: FriendInfo;
  // 新消息条数
  newMsgNum: 1;
  // 1，右边的侧边栏，是否打开，展示私聊的好友信息，群聊的群成员信息
  // 2，chatList的消息列表是否需要展示，这个人的消息是否需要展示，你是否有拉黑这个人
  // 黑名单
  blackFlag: boolean;
  // 最后的消息时间
  lastMsgTime: Date;
  // 消息的列表，这里应该只存最后一条消息
  messageList: Array<MessageInfo>;
}

const chatInfo1: ChatInfo = {
  id: 1,
  type: ChatMsgTypeEnum.OneToOne,
  index: 1,
  chatId: "99",
  friendInfo: {
    signature: "走别人的路，让别人无路可走",
    sex: 1,
    wxid: "12345",
    area: "奥林帕斯山",
    nickname: "机器人", //昵称2
    avatar: "https://p.qqan.com/up/2020-7/2020070908330717953.jpg", //头像
    username: "99",
    remark: "偷懒的机器人", //备注
    notDisturb: true, // 免打扰
  },
  newMsgNum: 1, //新消息条数
  blackFlag: true,
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

const chatInfo2: ChatInfo = {
  id: 2,
  type: ChatMsgTypeEnum.OneToOne,
  index: 2,
  chatId: "98",
  friendInfo: {
    signature: "走别人的路，让别人无路可走",
    sex: 1,
    wxid: "12345",
    area: "奥林帕斯山",
    nickname: "机器人", //昵称2
    avatar:
      "https://tupian.qqw21.com/article/UploadPic/2020-1/2020127275788240.jpg", //头像
    username: "99",
    remark: "偷懒的雪糕", //备注
    notDisturb: true, // 免打扰
  },
  newMsgNum: 1, //新消息条数
  blackFlag: true,
  lastMsgTime: new Date(),
  messageList: [
    {
      id: 1,
      sendUid: "1",
      sendUName: "1",
      username: "98",
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
  chatInfoList.push(chatInfo2);
  console.log(" getChatInfoList ");
  return chatInfoList;
}

export { ChatInfo, getChatInfoList };
