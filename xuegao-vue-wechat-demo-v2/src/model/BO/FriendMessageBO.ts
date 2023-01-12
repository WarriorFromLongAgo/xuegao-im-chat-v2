import { FriendMessageDO } from "@/model/DO/FriendMessageDO";

export { FriendMessageBO };

interface FriendMessageBO extends FriendMessageDO {
  // 是否展示时间，没批消息的第一条需要展示时间
  showTime: boolean;
  // 是否是自己发送的消息
  mySelfFlag: boolean;
}
