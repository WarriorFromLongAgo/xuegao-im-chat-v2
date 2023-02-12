insert into friend_user(id, user_id, friend_id, created_by, created_time, updated_by, updated_time, trace_id)
VALUES (null, 1, 2, 'system', now(), 'system', now(), null),
       (null, 1, 3, 'system', now(), 'system', now(), null),
       (null, 1, 4, 'system', now(), 'system', now(), null);
insert into friend_user(id, user_id, friend_id, created_by, created_time, updated_by, updated_time, trace_id)
VALUES (null, 2, 3, 'system', now(), 'system', now(), null),
       (null, 2, 4, 'system', now(), 'system', now(), null);
insert into friend_user(id, user_id, friend_id, created_by, created_time, updated_by, updated_time, trace_id)
VALUES (null, 3, 4, 'system', now(), 'system', now(), null);

select fu.*
from friend_user as fu
         left join friend_message as fm on fu.user_id = fm.user_id
where fu.user_id = 2;

select fu.*
from friend_user as fu
         left join friend_message as fm on fu.user_id = fm.user_id and fm.data_status = 10
where fu.user_id = 2
;
