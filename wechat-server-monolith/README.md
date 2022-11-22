# readme china
```
wechat-server-monolith 是一个springboot工程，它是一个im服务端

xuegao-vue-wechat-demo-v2 是一个vue工程，它是一个im客户端
vue3, ts, eslint, yarn

如果您想运行项目，请阅读 run project 部分

如果觉得不错，可以点个star，谢谢！
```

# readme english
English is not my native language; please excuse typing errors.

```
wechat-server-monolith is springboot project, it is a im server

xuegao-vue-wechat-demo-v2 is vue project, it is a im client
vue3, ts, eslint, yarn

please read run project part, if you want to run project

thanks for your star
```

# run project

```
git clone git@github.com:WarriorFromLongAgo/xue-gao-framework.git

cd xue-gao-framework

mvn clean source:jar install -Dmaven.test.skip=true

git clone git@github.com:WarriorFromLongAgo/xuegao-im-chat-v2.git

use idea open xuegao-im-chat-v2

run com.xuegao.wechatservermonolith.WechatServerMonolithApplication

your computer file path 
-javaagent:C:\Users\65126\devTool\GitProject_c\xuegao-im-chat-v2\wechat-server-monolith\src\main\resources\transmittable-thread-local-2.13.2.jar 
-javaagent:C:\Users\65126\Downloads\skywalking-agent\skywalking-agent.jar

```

# other
```
初学者，此项目是全栈项目，请先了解maven，springboot，mybatis，mybatis-plus，vue，等知识，再来看这个项目
当然如果你只是前端或者后端，也可以看看，有些地方可以学习一下，欢迎交流
有问题请先在issue里面提问，我会尽快回复

if you have any question, please ask in issue, I will reply as soon as possible
gmail: hubeixuegao@gmail.com
```

# 概念
```
chatList: 聊天列表，
也就是根据登陆人查询出所有的会话，最近的聊天记录，根据最后发送消息的时间，进行倒序
    根据登陆人的userId，
    查询出所有的chat，然后根据chatId，查询出所有的message，
    然后根据messageId，查询出所有的messageContent

单个chat需要什么
    未读的消息总数
私聊的chat
    朋友的信息
    最后一条消息的内容
    最后一条消息的时间
    最后一条消息的发送人
    最后一条消息的发送人的昵称
    最后一条消息的发送人的id
    最后一条消息的发送人的类型
群聊的chat
    



每一个chat，都有type，要从不同的字段拿取信息，进行展示，





message
各个消息类型发送出来的东西，朋友的消息，群的消息，公众号的消息，都是message




```



