import { reactive } from "vue";
import { ISysUser } from "@/service/login/call/response/SysUserResponse";
import { CONSTANT_YES_NO } from "@/common/constant";

interface ILoginInfo {
  // 网络状态, yes正常，no不正常
  networkState: string;
  networkStateCount: number;
  // token 安全信息
  token: string;
  // 登录人的信息
  sysUser: ISysUser;
}

const loginInfo: ILoginInfo = {
  // 默认true是正常的
  networkState: CONSTANT_YES_NO.YES,
  networkStateCount: 0,
  token: "",
  sysUser: {
    username: "",
    nickname: "",
    uid: "",
  },
};

function createState() {
  return reactive(loginInfo);
}

export { loginInfo, ILoginInfo, createState };
