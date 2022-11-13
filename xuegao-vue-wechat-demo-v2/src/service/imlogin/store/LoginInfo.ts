import { reactive } from "vue";
import { ISysUser } from "@/service/imlogin/call/response/SysUserResponse";

interface ILoginInfo {
  networkState: boolean;
  status: string;
  token: string;
  sysUser: ISysUser;
}

const loginInfo: ILoginInfo = {
  // 默认true是正常的
  networkState: true,
  status: "",
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
