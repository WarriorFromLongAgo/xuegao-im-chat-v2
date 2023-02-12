import { ISysUserReq } from "@/service/login/call/request/SysUserRequest";
import { ISysUserResp } from "@/service/login/call/response/SysUserResponse";
import http from "@/common/axios2";
import { Result } from "@/common/axios2/Result";

const registerHttp = async (sysUser: ISysUserReq): Promise<string> => {
  const result: Result<string> = await http.post<ISysUserReq, string>(
    "/sysUser/register",
    sysUser
  );
  // console.log("registerHttp result ", JSON.stringify(result));
  const { data: userId } = result;
  // console.log("loginHttp data ", JSON.stringify(sysUserResp));
  return userId;
};

const loginHttp = async (sysUser: ISysUserReq): Promise<ISysUserResp> => {
  const result: Result<ISysUserResp> = await http.post<
    ISysUserReq,
    ISysUserResp
  >("/sysUser/login", sysUser);
  // console.log("loginHttp result ", JSON.stringify(result));
  const { data: sysUserResp } = result;
  // console.log("loginHttp data ", JSON.stringify(sysUserResp));
  return sysUserResp;
};

export { registerHttp, loginHttp };
