// package com.xuegao.wechatservermonolith.framework.enums;
//
// public enum HttpCode {
//
//     SUCCESS_200(200, "请求成功"),
//     SUCCESS_201(201, "POST 创建数据成功"),
//     SUCCESS_202(202, "Accepted，提前响应结果"),
//     SUCCESS_204(204, "No Content，没有响应结果"),
//     SUCCESS_205(205, "Reset Content，提示Client重新获取"),
//
//     REDIRECT(302, "链接已经被重定向"),
//
//     CLIENT_BAD_REQUEST(400, "客户端请求的语法错误，服务器无法理解"),
//     CLIENT_UNAUTHORIZED(401, "请进行身份认证"),
//     CLIENT_FORBIDDEN(403, "服务器理解请求客户端的请求，但是拒绝执行此请求"),
//     CLIENT_NOT_FOUND(404, "服务器无法根据客户端的请求找到资源"),
//     CLIENT_METHOD_NOT_ALLOWED(405, "客户端请求中的方法被禁止"),
//
//     SERVER_ERROR(500, "系统异常，请联系管理员"),
//     SERVER_NOT_IMPLEMENTED(501, "服务器不支持请求的功能，无法完成请求"),
//     SERVER_BAD_GATEWAY(502, "网关或者代理工作的服务器 异常"),
//     SERVER_SERVICE_UNAVAILABLE(503, "系统维护"),
//     SERVER_GATEWAY_TIME_OUT(504, "充当网关或代理的服务器，未及时从远端服务器获取请求"),
//     SERVER_HTTPVERSION_NOT_SUPPORTED(505, "服务器不支持请求的HTTP协议的版本"),
//
//     LOGIN_ERROR(4000, "登录失败"),
//     LOGIN_UNKNOWN_ACCOUNT(4001, "找不到用户"),
//     LOGIN_INCORRECT_PSSWORD(4002, "密码错误"),
//     LOGIN_LOCKED_ACCOUNT(4003, "冻结的账户"),
//     LOGIN_LOGINED_ERROR(4004, "已经登录"),
//     LOGIN_NOT_LOGIN_ERROR(4005, "未登录"),
//
//     PARAM_VALIDATE_ERROR(5000, "参数校验错误"),
//     SQL_ERROR(5100, "sql操作异常"),
//     REDIS_ERROR(5101, "redis操作异常"),
//     FILE_ERROR(5200, "文件操作异常"),
//
//     NULL_ERROR(9999, "系统错误:空指针异常-内存中存在调用空对象的方法"),
//
//     ;
//     private Integer httpCode;
//     private String message;
//
//     HttpCode(Integer httpCode, String message) {
//         this.httpCode = httpCode;
//         this.message = message;
//     }
//
//     public Integer getHttpCode() {
//         return this.httpCode;
//     }
//
//     // 枚举的字段必须是不可变的
//     // public void setHttpCode(Integer httpCode) {
//     //     this.httpCode = httpCode;
//     // }
//
//     public String getMessage() {
//         return this.message;
//     }
//
//     // 枚举的字段必须是不可变的
//     // public void setMessage(String message) {
//     //     this.message = message;
//     // }
//
// }
