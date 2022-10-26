# v1（非此项目）
测试版本
# 人的基本信息
1，自增长的long id，登录页面要请求这个接口，展示在页面上
2，登录or注册接口，将注册信息传递到后台，后台返回id给前端
3，缓存map
key = 人id
value = 人的相关信息
例如：账号username，昵称，头像，等等
4，通过username查询人id的方法
5，缓存map
key = username
value = 人id

# 好友关系
1，好友map
key = 人id
value = set(人id)
2，好友map，相关信息
key 人id
value = map<人id，相关信息>
相关信息 = 备注，免打扰，

# 群的基本信息
1，自增长的long id，新增群的时候要请求这个接口，展示在页面上
2，新增群的接口，将数据传到后台，前端刷新一下列表就行
3，

# 群成员
1，群map
key = 群id
value = set(人id)
2，人map
这个人加了多少个群
key = 人id
value = set(群id)

# 私聊消息历史记录
用一个list存起来就行了

# 群聊消息历史记录


# 最新消息
最新的消息可能是人发的，也可能是群发的
维护一个消息id的字段，，，将列表返回给前端，，，这个列表有lastMsgId
根据这个字段进行排序

# 项目启动的时候维护
三个测试人员，test1，test2，test3
两个测试群，group1，group2
