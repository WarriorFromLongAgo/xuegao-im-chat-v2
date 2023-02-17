INSERT INTO xue_gao_im_chat_v2.xue_gao_user (id, username, password, uid, nickname, gender, avatar, mobile_phone,
                                             landline_phone, email, last_login_time, user_status, created_by,
                                             updated_by)
VALUES (null, 'aa', '123456', 'pLxpS2px8f9waD86x0A41SogTGo', 'aa', 1, null, null, null, null, '2023-02-17 09:41:59', 10,
        '0', '0');
INSERT INTO xue_gao_im_chat_v2.xue_gao_user (id, username, password, uid, nickname, gender, avatar, mobile_phone,
                                             landline_phone, email, last_login_time, user_status, created_by,
                                             updated_by)
VALUES (null, 'bb', '123456', '8WagnEIFC9NVUfHXgsTkakxnlSI', 'bb', 1, null, null, null, null, '2023-02-17 01:42:15', 10,
        '0', '0');

insert into friend_user(id, user_id, friend_id, created_by, created_time, updated_by, updated_time, trace_id)
VALUES (null, 1, 2, 'system', now(), 'system', now(), null),
       (null, 1, 3, 'system', now(), 'system', now(), null),
       (null, 1, 4, 'system', now(), 'system', now(), null);
insert into friend_user(id, user_id, friend_id, created_by, created_time, updated_by, updated_time, trace_id)
VALUES (null, 2, 3, 'system', now(), 'system', now(), null),
       (null, 2, 4, 'system', now(), 'system', now(), null);
insert into friend_user(id, user_id, friend_id, created_by, created_time, updated_by, updated_time, trace_id)
VALUES (null, 3, 4, 'system', now(), 'system', now(), null);
insert into friend_user(id, user_id, friend_id, created_by, created_time, updated_by, updated_time, trace_id)
VALUES (null, 3, 1, 'system', now(), 'system', now(), null);

select fu.*, fm.*
from friend_user as fu
         left join friend_message as fm on fu.user_id = fm.user_id and fm.data_status = 10 and fm.del_flag = 1
where fu.user_id = 3
  and fu.del_flag = 1
order by fm.id desc;

select fm.id,
       fm.user_id,
       fm.friend_id,
       fm.message_type,
       fm.content
from friend_message as fm
where fm.del_flag = 1
  and fm.data_status = 10
  and fm.user_id = 3
group by fm.user_id, fm.friend_id
order by id desc;

insert
into friend_message(id, user_id, friend_id, message_type, content, ack_type, data_status, created_by,
                    updated_by)
VALUES (null, 4, 3, 'text', '您好，我是id=4，我通过了你的朋友验证请求，现在我们可以开始聊天了', 10, 10, 'system', 'system'),
       (null, 3, 4, 'text', 'hello 我是 3', 10, 10, 'system', 'system'),
       (null, 3, 4, 'text', '3你好，我是4', 10, 10, 'system', 'system');
insert
into friend_message(id, user_id, friend_id, message_type, content, ack_type, data_status, created_by,
                    updated_by)
VALUES (null, 3, 1, 'text', '您好，我是id=3，我有一个问题想请问你。', 10, 10, 'system', 'system'),
       (null, 1, 3, 'text', '您好，我是gm99999，有什么可以帮助你的', 10, 10, 'system', 'system');

select fu.*
from friend_user as fu
where fu.user_id = 3
  and fu.friend_id in (1, 2, 3, 4)
  and fu.del_flag = 1;



select id,
       created_by,
       created_time,
       updated_by,
       updated_time,
       del_flag,
       trace_id,
       user_id,
       friend_id,
       message_type,
       content,
       ack_type,
       data_status
from friend_message as fm
where fm.del_flag = 1
  and fm.data_status = 10
  and fm.user_id = 3
group by fm.user_id, fm.friend_id

