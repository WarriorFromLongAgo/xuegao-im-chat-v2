import { GenericModel } from "@/model/DO/GenericModel";

interface SysUserBO extends GenericModel {
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
   * 头像
   */
  avatar: string;
}

export { SysUserBO };
