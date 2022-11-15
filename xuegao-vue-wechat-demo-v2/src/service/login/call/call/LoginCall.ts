import { Request } from "@/common/axios/request";
import { ISysUserReq } from "@/service/login/call/request/SysUserRequest";
import { ISysUserResp } from "@/service/login/call/response/SysUserResponse";
import { Result, RespCodeEnum } from "@/common/axios/response";

export class LoginCall {
  static async register(sysUser: ISysUserReq): Promise<Result<string>> {
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

  static async login(sysUser: ISysUserReq): Promise<Result<ISysUserResp>> {
    const newVar: Result<ISysUserResp> = await Request.post(
      "/sysUser/login",
      sysUser
    );
    if (RespCodeEnum.code_200 !== newVar.code) {
      throw new Error(newVar.message);
    }
    return newVar;
  }
}
