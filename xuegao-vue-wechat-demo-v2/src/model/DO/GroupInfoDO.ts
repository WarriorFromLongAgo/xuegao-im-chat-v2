import { GenericModel } from "@/model/DO/GenericModel";

/**
 * 群的基础信息
 */
interface GroupInfoDO extends GenericModel {
  /**
   * 群名称
   */
  name: string;
  /**
   * 群介绍
   */
  description: string;
  /**
   * 群主的user_id
   */
  ownerId: string;
}

export { GroupInfoDO };
