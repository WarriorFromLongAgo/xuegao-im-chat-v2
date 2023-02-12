export {
  HeaderToken,
  HeaderUserInfo,
  ResultEnum,
  RequestMethodEnum,
  ContentTypeEnum,
  RequestTimeOut,
};

const RequestTimeOut = 1000 * 5;

const HeaderToken = "token";

enum HeaderUserInfo {
  userId = "userId",
  username = "username",
  userNumber = "userNumber",
  nickname = "nickname",
  phone = "phone",
  ipAdder = "ipAdder",
}

enum ResultEnum {
  SUCCESS = 200,
  ERROR = 500,
  LOGIN_ERROR = 401,
}

enum RequestMethodEnum {
  GET = "GET",
  POST = "POST",
  PATCH = "PATCH",
  PUT = "PUT",
  DELETE = "DELETE",
  OPTIONS = "OPTIONS",
}

enum ContentTypeEnum {
  // json
  JSON = "application/json;charset=UTF-8",
  // text
  TEXT = "text/plain;charset=UTF-8",
  // form-data 一般配合qs
  FORM_URLENCODED = "application/x-www-form-urlencoded;charset=UTF-8",
  // form-data 上传
  FORM_DATA = "multipart/form-data;charset=UTF-8",
}
