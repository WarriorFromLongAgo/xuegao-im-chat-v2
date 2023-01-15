import { ILoginInfo } from "@/service/login/store/LoginInfoBO";
import { ISysUser } from "@/service/login/call/response/SysUserResponse";
import { CONSTANT_YES_NO } from "@/common/constant";

function getLoginInfo(state: ILoginInfo) {
  return () => {
    return state;
  };
}

function getToken(state: ILoginInfo) {
  return () => {
    return state.token;
  };
}

function getLoginSysUser(state: ILoginInfo) {
  return () => {
    return state.sysUser;
  };
}

function updateNetworkState(state: ILoginInfo) {
  return (networkState: CONSTANT_YES_NO) => {
    state.networkState = networkState;
  };
}

function incrementNetworkStateCount(state: ILoginInfo) {
  return () => {
    state.networkStateCount += state.networkStateCount;
    if (state.networkStateCount >= 3) {
      state.networkState = CONSTANT_YES_NO.NO;
    }
    return state.networkStateCount;
  };
}

function updateToken(state: ILoginInfo) {
  return (token: string) => {
    state.token = token;
  };
}

function updateLoginUser(state: ILoginInfo) {
  return (sysUser: ISysUser) => {
    const oldSysUser = state.sysUser;
    oldSysUser.username = sysUser.username;
    oldSysUser.uid = sysUser.uid;
    oldSysUser.nickname = sysUser.nickname;
    state.sysUser = oldSysUser;
  };
}

/**
 * 创建Action
 */
export function createAction(state: ILoginInfo) {
  return {
    updateToken: updateToken(state),
    updateNetworkState: updateNetworkState(state),
    incrementNetworkStateCount: incrementNetworkStateCount(state),
    updateLoginUser: updateLoginUser(state),

    getLoginInfo: getLoginInfo(state),
    getLoginSysUser: getLoginSysUser(state),
    getToken: getToken(state),
  };
}
