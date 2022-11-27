# xuegao-im-chat-v2
```
English is not my native language; please excuse typing errors.
```
# wechat-server-monolith（单体架构）
一个仿pc微信的Java项目，是xuegao-vue-wechat-demo-v2项目的后端
```
wechat-server-monolith 是一个springboot工程，它是一个im服务端

wechat-server-monolith is springboot project, it is a im server
```

# xuegao-vue-wechat-demo-v2
一个仿pc微信的纯vue项目，是xuegao-im-chat-2022项目的前端，来自 TomHusky/vue-wechat-demo
```
xuegao-vue-wechat-demo-v2 是一个vue工程，它是一个im客户端
vue3, ts, eslint, yarn

xuegao-vue-wechat-demo-v2 is vue project, it is a im client
vue3, ts, eslint, yarn
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