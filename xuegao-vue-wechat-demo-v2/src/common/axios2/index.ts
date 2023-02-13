import axios, {
  AxiosInstance,
  AxiosError,
  AxiosRequestConfig,
  AxiosResponse,
} from "axios";
import { apiUrl } from "@/common/config/config";
import {
  HeaderToken,
  HeaderUserInfo,
  RequestTimeOut,
  ResultEnum,
} from "@/common/AxiosConstant";
import { LocalCacheUtil } from "@/common/LocalCache";
import { checkStatus } from "@/common/axios2/checkStatus";
import { Result } from "@/common/axios2/Result";
import { InternalAxiosRequestConfig } from "axios";

const config = {
  // 默认地址请求地址，可在 .env.*** 文件中修改
  baseURL: apiUrl,
  // 设置超时时间（10s）
  timeout: RequestTimeOut as number,
};

class RequestHttp {
  axiosInstance: AxiosInstance;

  public constructor(config: AxiosRequestConfig) {
    console.log(" constructor ", config);
    // 实例化axios
    this.axiosInstance = axios.create(config);

    const localCacheUtil = new LocalCacheUtil();
    const localToken = localCacheUtil.get(HeaderToken);

    const userId = localCacheUtil.get(HeaderUserInfo.userId);
    const username = localCacheUtil.get(HeaderUserInfo.username);
    const userNumber = localCacheUtil.get(HeaderUserInfo.userNumber);
    const nickname = localCacheUtil.get(HeaderUserInfo.nickname);
    const phone = localCacheUtil.get(HeaderUserInfo.phone);
    const ipAdder = localCacheUtil.get(HeaderUserInfo.ipAdder);

    this.axiosInstance.interceptors.request.use(
      (config: InternalAxiosRequestConfig) => {
        // console.log(" config 1 ", JSON.stringify(config));
        config.headers.token = localToken;
        config.headers.userId = userId;
        config.headers.username = username;
        config.headers.nickname = nickname;
        config.headers.userNumber = userNumber;
        config.headers.phone = phone;
        config.headers.ipAdder = ipAdder;
        // console.log(" config 100 ", JSON.stringify(config));
        return config;
      },
      (error: AxiosError) => {
        return Promise.reject(error);
      }
    );

    /**
     * @description 响应拦截器
     *  服务器换返回信息 -> [拦截统一处理] -> 客户端JS获取到信息
     */
    this.axiosInstance.interceptors.response.use(
      (response: AxiosResponse) => {
        console.log("响应拦截器，执行, ", JSON.stringify(response));
        const { data } = response;
        // * 登陆失效（code == 401）
        if (data.code == ResultEnum.LOGIN_ERROR) {
          alert(" LOGIN_ERROR ");
          return Promise.reject(data);
        }
        // * 全局错误信息拦截（防止下载文件得时候返回数据流，没有code，直接报错）
        if (data.code && data.code !== ResultEnum.SUCCESS) {
          alert(" data.code !== ResultEnum.SUCCESS ");
          return Promise.reject(data);
        }
        // * 成功请求（在页面上除非特殊情况，否则不用在页面处理失败逻辑）
        return data;
      },
      async (error: AxiosError) => {
        const { response } = error;
        // 请求超时 && 网络错误单独判断，没有 response
        if (error.message.indexOf("timeout") !== -1) {
          alert(" 请求超时！请您稍后重试");
        }
        if (error.message.indexOf("Network Error") !== -1) {
          alert(" 网络错误！请您稍后重试");
        }
        // 根据响应的错误状态码，做不同的处理
        if (response) {
          checkStatus(response.status);
        }
        // 服务器结果都没有返回(可能服务器错误可能客户端断网)，断网处理:可以跳转到断网页面
        // if (!window.navigator.onLine) router.replace("/500");
        return Promise.reject(error);
      }
    );
  }

  // * 常用请求方法封装
  get<Request, Response>(
    url: string,
    params?: Request
  ): Promise<Result<Response>> {
    return this.axiosInstance.get(url, { params });
  }

  post<Request, Response>(
    url: string,
    params?: Request
  ): Promise<Result<Response>> {
    return this.axiosInstance.post(url, params);
  }

  // put<T>(url: string, params?: object, _object = {}): Promise<ResultData<T>> {
  //   return this.service.put(url, params, _object);
  // }
  // delete<T>(url: string, params?: any, _object = {}): Promise<ResultData<T>> {
  //   return this.service.delete(url, { params, ..._object });
  // }
}

export default new RequestHttp(config);
