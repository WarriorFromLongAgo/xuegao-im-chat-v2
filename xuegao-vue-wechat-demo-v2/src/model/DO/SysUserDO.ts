import { GenericModel } from "@/model/DO/GenericModel";

interface SysUserDO extends GenericModel {
  /**
   * 用户的账户名
   */
  username: string;
  /**
   * uuid，用户的唯一标识
   */
  uid: string;
  /**
   * 展示出来的昵称
   */
  nickname: string;
  /**
   * 性别,1男，2女，3其他
   */
  gender: string;
  /**
   * 头像
   */
  avatar: string;
  /**
   * 手机号码
   */
  mobilePhone: string;
  /**
   * 固定电话
   */
  landlinePhone: string;
  /**
   * 邮箱
   */
  email: string;
  /**
   * 最后登录的年月日
   */
  lastLoginTime: string;
  /**
   * 用户状态,10:正常,20:3个月未登录进行删除锁定,30自主销号
   */
  userStatus: string;
  /**
   * 用户注册的时候 用户ip
   */
  userIp: string;
  /**
   * 用户注册的时候 省份
   */
  userProvince: string;
  /**
   * 用户注册的时候 城市
   */
  userCity: string;
  /**
   * 用户注册的时候 城市区号
   */
  userCityCode: string;
  /**
   * 签名
   */
  signature: string;
}

export { SysUserDO };
