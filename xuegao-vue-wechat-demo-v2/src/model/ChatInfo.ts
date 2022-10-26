import {FriendInfo} from "@/model/FriendInfo";
import {MessageInfo} from "@/model/MessageInfo";

// 聊天会话 列表
export interface ChatInfo {
    // 好像没有意义
    id: number,
    // 1 私聊，2 群聊
    type: number,
    // 聊天在会话列表的位置
    index: number,
    // 人id，或者是，群id
    chatId: string,
    // 会话的详细信息
    info: FriendInfo,
    // 新消息条数
    newMsgNum: 1,

    isShow: true,
    lastMsgTime: Date,
    messages: Array<MessageInfo>

}

export interface ChatInfoList {
    chatList: Array<ChatInfo>;
}
