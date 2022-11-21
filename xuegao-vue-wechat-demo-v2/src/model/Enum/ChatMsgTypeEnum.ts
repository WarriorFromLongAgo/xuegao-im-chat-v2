/**
 * 会话，是什么类型
 * 消息，是什么类型
 *
 * 二合一方案
 */
export enum ChatMsgTypeEnum {
  // region 系统层面的消息或者会话
  /**
   * 系统机器人
   */
  Robot = 0,
  /**
   * 系统通知
   */
  SystemNotify = 1,
  /**
   * 心跳，发送
   */
  HeartBeatPing = 2,
  /**
   * 心跳，接收
   */
  HeartBeatPong = 3,
  /**
   * 文字消息
   */
  Text,
  /**
   * 图片消息
   */
  Image,
  /**
   * 音频消息
   */
  Audio,
  /**
   * 视频消息
   */
  Video,

  // endregion

  // region 人和人之间的会话
  /**
   * 私聊
   */
  OneToOne = 1000,
  /**
   * 群聊
   */
  ManyToMany = 1001,
  // endregion

  // region 其他会话
  /**
   * 文件发送助手
   */
  FileSend = 10000,
  /**
   * 服务订阅号
   */
  ServiceSubscription = 10001,
  // endregion
}
