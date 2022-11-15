// request.ts
import axios from "./index";
import qs from "qs";
import { Result } from "@/common/axios/response";

export class Request {
  //Promise类型需要接收一个泛型参数（目的是为了定义响应数据的类型）
  //T用于指定响应数据中data的类型
  static async get<T>(url: string, params?: any): Promise<Result<T>> {
    return new Promise((resolve, reject) => {
      axios
        .get(url, params)
        .then((res) => {
          resolve(res.data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  //Promise类型需要接收一个泛型参数（目的是为了定义响应数据的类型）
  //T用于指定响应数据中data的类型
  static async post<T>(url: string, params?: any): Promise<Result<T>> {
    return new Promise((resolve, reject) => {
      axios
        .post(url, qs.parse(params), {
          headers: { "Content-type": "application/json" },
        })
        .then((res) => {
          resolve(res.data);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }
}
