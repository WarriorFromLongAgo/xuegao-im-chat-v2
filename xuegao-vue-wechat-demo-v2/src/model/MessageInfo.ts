export { MessageInfo, getMessageInfoList };

const now = new Date();

interface MessageInfo {
  id: number;
  // 发送人 uid
  sendUid: string;
  // 发送人 uName，去 localStorage 获取
  sendUName: string;
  // 发送人 uName，去 localStorage 获取
  username: string;
  // 发送类型，0系统通知, 1私聊，2群聊，3ping，4pong，
  // MsgType 枚举类
  msgType: number;
  // 发送类型，0系统通知, 1私聊，2群聊，3ping，4pong，
  // MsgType 枚举类
  type: number;
  // 内容
  content: string;
  // 时间戳
  date: Date;
  // 是否展示时间，没批消息的第一条需要展示时间
  showTime: boolean;
  // 这个字段到底是什么呢
  self: boolean;
}

const msg1: MessageInfo = {
  id: 1,
  sendUid: "1",
  sendUName: "1",
  username: "99",
  msgType: 1,
  type: 1,
  content: "我已经通过你的好友请求，现在可以开始聊天了",
  date: now,
  showTime: true,
  self: true,
};

const msg2: MessageInfo = {
  id: 2,
  sendUid: "1",
  sendUName: "1",
  username: "99",
  msgType: 1,
  type: 1,
  content: "hello 我叫麻花藤",
  date: now,
  showTime: true,
  self: true,
};

function getMessageInfoList(): Array<MessageInfo> {
  const messageInfoList: Array<MessageInfo> = new Array<MessageInfo>();

  messageInfoList.push(msg1);
  messageInfoList.push(msg2);
  console.log(" getMessageInfoList ");
  return messageInfoList;
}
