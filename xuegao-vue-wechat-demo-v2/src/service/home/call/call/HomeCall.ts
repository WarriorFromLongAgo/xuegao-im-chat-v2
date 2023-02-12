// import { Request } from "@/common/axios/request";
// import { Result, RespCodeEnum } from "@/common/axios/response";
// import { LocalCacheUtil } from "@/common/LocalCache";
// import { SysUserBO } from "@/model/BO/SysUserBO";
//
// export class HomeCall {
//   static async getUserByToken(): Promise<unknown> {
//     const localCacheUtil = new LocalCacheUtil();
//     // const newVar: Result<SysUserDO> = Request.post("/sysUser/getUserByToken", {
//     //   vo: localCacheUtil.get("token"),
//     // });
//     let returnValue: SysUserBO;
//     const promise = Request.post("/sysUser/getUserByToken", {
//       vo: localCacheUtil.get("token"),
//     })
//       .then(function (response) {
//         console.log("getUserByToken then ", response);
//         if (RespCodeEnum.code_200 !== response.code) {
//           throw new Error(response.message);
//         }
//         response.data;
//       })
//       .catch(function (error) {
//         console.log("getUserByToken catch ", error);
//         alert("  getUserByToken 异常 ");
//         throw new Error(" getUserByToken 异常 ");
//       });
//     await promise;
//     console.log("getUserByToken end ", promise);
//     return returnValue;
//   }
// }
