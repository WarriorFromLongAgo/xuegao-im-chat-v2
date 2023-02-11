import { Request } from "@/common/axios/request";
import { Result, RespCodeEnum } from "@/common/axios/response";
import { SysUserDO } from "@/model/DO/SysUserDO";
import { LocalCacheUtil } from "@/common/LocalCache";

export class HomeCall {
  static async getUserByToken(): Promise<Result<SysUserDO>> {
    const localCacheUtil = new LocalCacheUtil();
    const newVar: Result<SysUserDO> = await Request.post(
      "/sysUser/getUserByToken",
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
