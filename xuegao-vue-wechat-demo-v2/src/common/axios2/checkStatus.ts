/**
 * @description: 校验网络请求状态码
 * @param {Number} status
 * @return void
 */
export const checkStatus = (status: number): void => {
  switch (status) {
    case 400:
      alert("请求失败！请您稍后重试");
      break;
    case 401:
      alert("登录失效！请您重新登录");
      break;
    case 403:
      alert("当前账号无权限访问！");
      break;
    case 404:
      alert("你所访问的资源不存在！");
      break;
    case 405:
      alert("请求方式错误！请您稍后重试");
      break;
    case 408:
      alert("请求超时！请您稍后重试");
      break;
    case 500:
      alert("服务异常！");
      break;
    case 502:
      alert("网关错误！");
      break;
    case 503:
      alert("服务不可用！");
      break;
    case 504:
      alert("网关超时！");
      break;
    default:
      alert("请求失败！");
  }
};
