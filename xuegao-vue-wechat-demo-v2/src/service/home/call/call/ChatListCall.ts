import { RespCodeEnum, Result } from "@/common/axios/response";
import { SysUserDO } from "@/model/DO/SysUserDO";
import { LocalCacheUtil } from "@/common/LocalCache";
import { Request } from "@/common/axios/request";

export class ChatListCall {
  static async listChatInfo(): Promise<Result<SysUserDO>> {
    const localCacheUtil = new LocalCacheUtil();
    const newVar: Result<SysUserDO> = await Request.post(
      "/sysUser/listChatInfo",
      {
        vo: localCacheUtil.get("token"),
      }
    );
    if (RespCodeEnum.code_200 !== newVar.code) {
      alert(newVar.message);
      // throw new Error(newVar.message);
      return newVar;
    }
    return newVar;
  }
}
