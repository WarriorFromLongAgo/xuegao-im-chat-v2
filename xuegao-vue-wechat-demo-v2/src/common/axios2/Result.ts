// * 请求响应参数(不包含data)
export interface BaseResult {
  code: number;
  message: string;
  traceId: string;
}

// * 请求响应参数(包含data)
export interface Result<T = never> extends BaseResult {
  data: T;
}

// * 请求响应参数(包含data)
export interface PageResult<T = never> extends BaseResult {
  total: string;
  rowList: Array<T>;
}
