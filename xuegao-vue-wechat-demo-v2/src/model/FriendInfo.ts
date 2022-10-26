import {UserInfo} from "@/model/UserInfo";

// 人和人之间的关系
export interface FriendInfo extends UserInfo {
    // 免打扰
    notDisturb: boolean,
    // 备注
    remark: string

}
