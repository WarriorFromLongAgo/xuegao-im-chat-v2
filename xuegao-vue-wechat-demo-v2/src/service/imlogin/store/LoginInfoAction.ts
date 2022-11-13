import { ILoginInfo, loginInfo } from "@/service/imlogin/store/LoginInfo";
import { ISysUser } from "@/service/imlogin/call/response/SysUserResponse";

function getLoginInfo() {
  return loginInfo;
}

function getToken() {
  const token = getLoginInfo().token;
  console.log(" getToken ", token);
  return token;
}

function getSysUser() {
  const sysUser = getLoginInfo().sysUser;
  console.log(" getSysUser ", sysUser);
  return sysUser;
}

function updateNetworkState(networkState: boolean) {
  const loginInfo = getLoginInfo();
  console.log(" updateNetworkState 之前 loginInfo = ", loginInfo);
  loginInfo.networkState = networkState;
  console.log(" updateNetworkState 之后 loginInfo = ", loginInfo);
}

function updateStatus(status: string) {
  getLoginInfo().status = status;
  console.log(" updateStatus 之后 getLoginInfo() = ", getLoginInfo());
}

function updateToken(token: string) {
  getLoginInfo().token = token;
  console.log(" updateToken 之后 getLoginInfo() = ", getLoginInfo());
}

function updateUser(sysUser: ISysUser) {
  getLoginInfo().sysUser = sysUser;
  console.log(" updateUser 之后 getLoginInfo() = ", getLoginInfo());
}

/**
 * 创建Action
 * @param loginInfo
 */
export function createAction(loginInfo: ILoginInfo) {
  return {
    updateToken: updateToken(loginInfo.token),
    updateNetworkState: updateNetworkState(loginInfo.networkState),
    updateStatus: updateStatus(loginInfo.status),
    updateUser: updateUser(loginInfo.sysUser),

    getLoginInfo: getLoginInfo(),
    getSysUser: getSysUser(),
    getToken: getToken(),
  };
}
