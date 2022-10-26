export interface MessageInfo {
    // 发送人 uid
    sendUid: string,
    // 发送人 uName，去 localStorage 获取
    sendUName: string,
    // 发送人 uName，去 localStorage 获取
    username: string,
    // 发送类型，0系统通知, 1私聊，2群聊，3ping，4pong，
    // MsgType 枚举类
    msgType: number,
    // 发送类型，0系统通知, 1私聊，2群聊，3ping，4pong，
    // MsgType 枚举类
    type: number,
    // 内容
    content: string,
    // 时间戳
    date: Date,
    // 是否展示时间，没批消息的第一条需要展示时间
    showTime: boolean,

    // 这个字段到底是什么呢
    self: boolean
}
