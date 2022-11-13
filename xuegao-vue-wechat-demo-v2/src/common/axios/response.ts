export interface Result<T = any> {
  code: number;
  message: string;
  data: T;
  traceId: string;
  total: string;
  rowList: Array<T>;
}

export enum RespCodeEnum {
  code_200 = 200,
  code_500 = 500,
}
