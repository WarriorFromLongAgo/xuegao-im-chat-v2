import { ILoginInfo } from "@/service/login/store/LoginInfoBO";
import { ISysUser } from "@/service/login/call/response/SysUserResponse";
import { CONSTANT_YES_NO } from "@/common/constant";

function getLoginInfo(state: ILoginInfo) {
  return () => {
    return state;
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

function updateLoginUser(state: ILoginInfo) {
  return (sysUser: ISysUser) => {
    const oldSysUser = state.sysUser;
    oldSysUser.id = sysUser.id;
    oldSysUser.username = sysUser.username;
    oldSysUser.uid = sysUser.uid;
    oldSysUser.nickname = sysUser.nickname;
    state.sysUser = oldSysUser;
    console.log(" sysUser ", sysUser);
  };
}

/**
 * 创建Action
 */
export function createAction(state: ILoginInfo) {
  return {
    updateNetworkState: updateNetworkState(state),
    incrementNetworkStateCount: incrementNetworkStateCount(state),
    updateLoginUser: updateLoginUser(state),

    getLoginInfo: getLoginInfo(state),
    getLoginSysUser: getLoginSysUser(state),
  };
}
