import http from "@/common/axios2/index";
import { Result } from "@/common/axios2/Result";
import { SysUserBO } from "@/model/BO/SysUserBO";

const getUserByTokenHttp = async (): Promise<SysUserBO> => {
  const result: Result<SysUserBO> = await http.post<null, SysUserBO>(
    "/sysUser/getUserByToken"
  );
  // console.log("registerHttp result ", JSON.stringify(result));
  const { data: sysUserBO } = result;
  // console.log("registerHttp result ", JSON.stringify(sysUserBO));
  return sysUserBO;
};

export { getUserByTokenHttp };
