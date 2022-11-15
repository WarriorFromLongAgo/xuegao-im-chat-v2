import { loginInfo } from "@/service/login/store/LoginInfo";
import { ISysUser } from "@/service/login/call/response/SysUserResponse";
import { CONSTANT_YES_NO } from "@/common/constant";

function getLoginInfo() {
  return loginInfo;
}

function getToken(): string {
  return getLoginInfo().token;
}

function getSysUser() {
  return getLoginInfo().sysUser;
}

function updateNetworkState(networkState: CONSTANT_YES_NO) {
  getLoginInfo().networkState = networkState;
}

function incrementNetworkStateCount() {
  const loginInfo = getLoginInfo();
  let networkStateCount = loginInfo.networkStateCount;
  networkStateCount++;
  loginInfo.networkStateCount = networkStateCount;
  if (networkStateCount >= 3) {
    loginInfo.networkState = CONSTANT_YES_NO.NO;
  }
}

function updateToken(token: string) {
  getLoginInfo().token = token;
}

function updateUser(sysUser: ISysUser) {
  const loginInfo = getLoginInfo();
  const oldSysUser = loginInfo.sysUser;
  oldSysUser.username = sysUser.username;
  oldSysUser.uid = sysUser.uid;
  oldSysUser.nickname = sysUser.nickname;
  loginInfo.sysUser = oldSysUser;
}

/**
 * 创建Action
 * @param loginInfo
 */
export function createAction() {
  return {
    updateToken,
    updateNetworkState,
    incrementNetworkStateCount,
    updateUser,

    getLoginInfo,
    getSysUser,
    getToken,

    // updateToken: updateToken(loginInfo.token)
    // updateNetworkState: updateNetworkState(loginInfo.networkState),
    // updateStatus: updateStatus(loginInfo.status),
    // updateUser: updateUser(loginInfo.sysUser),
    //
    // getLoginInfo: getLoginInfo(),
    // getSysUser: getSysUser(),
    // getToken: getToken(),
  };
}
