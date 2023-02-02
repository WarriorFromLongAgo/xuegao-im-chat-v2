/**
 * 会话，是什么类型
 * 消息，是什么类型
 *
 * 二合一方案
 */
export enum MsgTypeEnum {
  // region 系统层面的消息或者会话
  /**
   * 1 = 文字消息
   */
  Text = 1,
  /**
   * 2 = 图片消息
   */
  Image = 2,
  /**
   * 3 = 音频消息
   */
  Audio = 3,
  /**
   * 4 = 视频消息
   */
  Video = 4,
  /**
   * 5 = 文件消息
   */
  File = 5,

  // endregion
}
