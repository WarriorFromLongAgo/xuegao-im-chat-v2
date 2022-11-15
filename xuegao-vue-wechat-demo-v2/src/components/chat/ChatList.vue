<template>
  <div class="msgList user-select-none">
    <ul>
      <template v-for="item in list">
        <li
          v-if="item.isShow"
          :key="item.id"
          class="chatList"
          @click="selectChat(item, item.chatId)"
        >
          <div class="list-left">
            <img
              class="avatar"
              width="40"
              height="40"
              :alt="
                item.friendInfo.remark === ''
                  ? item.friendInfo.nickname
                  : item.friendInfo.remark
              "
              :src="localAvatar1"
            />
          </div>
          <div class="list-right">
            <p class="name">
              {{
                item.friendInfo.remark === null || item.friendInfo.remark === ""
                  ? item.friendInfo.nickname
                  : item.friendInfo.remark
              }}
            </p>
            <span class="time" v-text="getTimes(item.lastMsgTime)"></span>
            <p
              class="lastMsg"
              v-html="
                replaceFace(
                  item.messageList.length > 0
                    ? item.messageList[item.messageList.length - 1]
                    : ''
                )
              "
            ></p>
          </div>
        </li>
      </template>
    </ul>
  </div>
</template>

<script lang="ts" setup>
import { ChatInfo, getChatInfoList } from "@/model/ChatInfo";
import { isEmpty } from "@/common/ObjectUtil";
import { replaceFace } from "@/model/Emoji";
import { computed } from "vue";

import localAvatar1 from "/public/static/images/vue.jpg";

console.log("  chat list 进来了");

let list = computed(() => {
  return getChatInfoList();
});

let selectChat = function (item: ChatInfo, chatId: string) {
  console.log(" item = ", item);
  console.log(" chatId = ", chatId);
};

let getTimes = function (lastMsgTime: Date) {
  console.log(" lastMsgTime ", lastMsgTime);
  if (isEmpty(lastMsgTime)) {
    return "";
  }
  if (lastMsgTime.getMinutes() < 10) {
    return lastMsgTime.getHours() + ":0" + lastMsgTime.getMinutes();
  } else {
    return lastMsgTime.getHours() + ":" + lastMsgTime.getMinutes();
  }
};
</script>

<style lang="css" scoped>
.msgList {
  width: 100%;
  height: 570px;
  overflow-y: auto;
}
.chatList {
  cursor: default;
  display: flex;
  padding: 12px;
  transition: background-color 0.1s;
  font-size: 0;
}
.chatList:hover {
  cursor: default;
  display: flex;
  padding: 12px;
  transition: background-color 0.1s;
  font-size: 0;
}
.chatList.active {
  cursor: default;
  display: flex;
  padding: 12px;
  transition: background-color 0.1s;
  font-size: 0;
}
.chatList .list-left {
  position: relative;
  margin-right: 12px;
}
.chatList .list-left.avatar {
  border-radius: 2px;
}
.chatList .list-right {
  position: relative;
  flex: 1;
  margin-top: 4px;
}
.chatList .list-right .name {
  display: inline-block;
  vertical-align: top;
  font-size: 14px;
}
.chatList .list-right .time {
  float: right;
  color: #999;
  font-size: 10px;
  vertical-align: top;
}
.chatList .list-right .lastMsg {
  position: absolute;
  font-size: 12px;
  width: 130px;
  height: 15px;
  line-height: 15px;
  color: #999;
  bottom: 0px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
