import { FriendUserDO } from "@/model/DO/FriendUserDO";

const friendUserDataOne: FriendUserDO = {
  id: "1",
  userId: "1",
  friendId: "2",
  notDisturb: false,
  friendNote: "",
  friendSource: "手机号搜索",
};

const friendUserDataTwo: FriendUserDO = {
  id: "2",
  userId: "1",
  friendId: "3",
  notDisturb: false,
  friendNote: "",
  friendSource: "昵称搜索",
};

const friendUserDataThree: FriendUserDO = {
  id: "3",
  userId: "2",
  friendId: "3",
  notDisturb: false,
  friendNote: "",
  friendSource: "uid搜索",
};

export { friendUserDataOne, friendUserDataTwo, friendUserDataThree };
