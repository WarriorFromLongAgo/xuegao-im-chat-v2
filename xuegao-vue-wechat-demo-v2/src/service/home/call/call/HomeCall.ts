import { Request } from "@/common/axios/request";
import { ISysUserReq } from "@/service/login/call/request/SysUserRequest";
import { ISysUserResp } from "@/service/login/call/response/SysUserResponse";
import { Result, RespCodeEnum } from "@/common/axios/response";

export class HomeCall {
  static async getUserByToken(): Promise<Result<string>> {
    const newVar: Result<string> = await Request.post(
      "/sysUser/register",
      sysUser
    );
    if (RespCodeEnum.code_200 !== newVar.code) {
      alert(newVar.message);
      // throw new Error(newVar.message);
      return newVar;
    }
    return newVar;
  }
}
