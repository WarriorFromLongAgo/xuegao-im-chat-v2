/**
 * 会话，是什么类型
 * 消息，是什么类型
 *
 * 二合一方案
 */
export enum MsgTypeEnum {
  // region 系统层面的消息或者会话
  /**
   * text = 文字消息
   */
  Text = "text",
  /**
   * image = 图片消息
   */
  Image = "image",
  /**
   * audio = 音频消息
   */
  Audio = "audio",
  /**
   * video = 视频消息
   */
  Video = "video",
  /**
   * file = 文件消息
   */
  File = "file",

  // endregion
}
