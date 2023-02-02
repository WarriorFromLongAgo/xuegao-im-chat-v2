/**
 * 会话，是什么类型
 * 消息，是什么类型
 *
 * 二合一方案
 */
export enum MsgSendTypeEnum {
  // region 系统层面的消息或者会话
  /**
   * 1 = 系统机器人
   */
  Robot = 1,
  /**
   * 2 = 系统通知
   */
  SystemNotify = 2,
  /**
   * 3 = 心跳，客户端发送
   */
  HeartBeatPing = 3,
  /**
   * 4 = 心跳，服务端发送
   */
  HeartBeatPong = 4,
  // endregion

  // region 人和人之间的会话
  /**
   * 5 = 私聊
   */
  OneToOne = 5,
  /**
   * 6 = 群聊
   */
  ManyToMany = 6,
  // endregion

  // region 其他会话
  /**
   * 7 = 文件发送助手
   */
  FileSend = 7,
  /**
   * 8 = 服务订阅号
   */
  ServiceSubscription = 8,
  // endregion
}
