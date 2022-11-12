package com.xuegao.wechatservermonolith.sysuser.model.doo;

import java.time.LocalDateTime;

public class XueGaoUser {
    /**
     *
     */
    String username;
    String password;
    String uid;

    Integer user_status;
    Integer gender;
    LocalDateTime last_login_time;
    String avatar;

    String landline_phone;
    String mobile_phone;
    String nickname;
    String email;
}