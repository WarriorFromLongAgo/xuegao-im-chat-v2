/**
 * 会话，是什么类型
 * 消息，是什么类型
 *
 * 二合一方案
 */
export enum MsgSendTypeEnum {
  // region 系统层面的消息或者会话
  /**
   * 0 = 未知
   */
  unKnown = 0,
  /**
   * 1 = 链接 websocket
   */
  wsOpen = 1,
  /**
   * 2 = 断开 websocket
   */
  wsClose = 2,
  /**
   * 3 = 发送 websocket 消息
   */
  wsMsg = 3,
  /**
   * 4 = 异常 websocket
   */
  wsError = 4,
  /**
   * 10001 = 系统机器人
   */
  Robot = 10001,
  /**
   * 10002 = 系统通知
   */
  SystemNotify = 10002,
  /**
   * 10003 = 心跳，客户端发送
   */
  HeartBeatPing = 10003,
  /**
   * 10004 = 心跳，服务端发送
   */
  HeartBeatPong = 10004,
  // endregion

  // region 人和人之间的会话
  /**
   * 10005 = 私聊
   */
  OneToOne = 10005,
  /**
   * 10006 = 群聊
   */
  ManyToMany = 10006,
  // endregion

  // region 其他会话
  /**
   * 10007 = 文件发送助手
   */
  FileSend = 10007,
  /**
   * 10008 = 服务订阅号
   */
  ServiceSubscription = 10008,
  // endregion
}
