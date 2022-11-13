import { Request } from "@/common/axios/request";
import { ISysUserReq } from "@/service/imlogin/call/request/SysUserRequest";
import { ISysUserResp } from "@/service/imlogin/call/response/SysUserResponse";
import { Result, RespCodeEnum } from "@/common/axios/response";

export class LoginCall {
  static async register(sysUser: ISysUserReq) {
    const newVar: Result<string> = await Request.post(
      "/sysUser/register",
      sysUser
    );
    if (RespCodeEnum.code_200 !== newVar.code) {
      throw new Error(newVar.message);
    }
    return newVar;
  }

  static async login(sysUser: ISysUserReq) {
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
