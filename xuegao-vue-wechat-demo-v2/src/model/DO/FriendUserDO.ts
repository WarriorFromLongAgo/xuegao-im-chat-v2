import { GenericModel } from "@/model/DO/GenericModel";

/**
 * 用户与朋友关系
 */
interface FriendUserDO extends GenericModel {
  /**
   * user_id，登陆人的id
   */
  userId: string;
  /**
   * friendId，朋友的id
   */
  friendId: string;
  /**
   * true，勿扰
   * false，正常接收消息
   */
  notDisturb: boolean;
  /**
   * 好友备注
   */
  friendNote: string;
  /**
   * friendSource
   * <p>
   * 后端直接告诉前端，直接返回中文，展示什么就行了
   */
  friendSource: string;
}

export { FriendUserDO };
