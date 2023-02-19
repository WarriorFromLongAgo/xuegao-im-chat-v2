<template>
  <div class="messageChatClass">
    <header class="header user-select-none">
      <div class="friendName">
        <span style="cursor: pointer" @click="showChatInfo"
          >item.friendInfo.remark</span
        >
      </div>
    </header>
    <!--      @mousewheel="mousewheel"-->
    <div class="message-wrapper scrollbar" @scroll="handleScroll" ref="list">
      <!--v-if="selectedChat"-->
      <ul>
        <li
          v-for="item in selectChatFriendMessageList"
          class="message-item"
          :key="item.id"
        >
          <div class="time selectNone">
            <span v-if="item.showTime">{{
              convertToTime(item.createdTime)
            }}</span>
          </div>
          <div
            class="main"
            :class="{
              self: item.mySelfFlag,
              other: !item.mySelfFlag,
            }"
          >
            <img
              class="avatar selectNone"
              width="36"
              height="36"
              :src="item.sysUserBO.avatar"
            />
            <div
              class="content"
              :class="{ 'text-msg': item.messageType === MsgTypeEnum.Text }"
            >
              <div
                class="text"
                v-if="MsgTypeEnum.Text === item.messageType"
                v-html="replaceToFaceByMsg(item)"
              ></div>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { computed } from "vue";
import { replaceToFaceByMsg } from "@/model/Emoji";
import { MsgTypeEnum } from "@/model/Enum/MsgTypeEnum";
import { useSelectChatMessageStore } from "@/service/chat/store/SelectChatMessageStore";

// 获取聊天记录
let selectChatFriendMessageList = computed(() => {
  return useSelectChatMessageStore().action.getFriendMessageList();
});

let showChatInfo = function () {
  console.log("  showChatInfo ");
};

let handleScroll = function () {
  console.log("  handleScroll ");
};

let convertToTime = function (date: Date) {
  if (date.getMinutes() < 10) {
    return date.getHours() + ":0" + date.getMinutes();
  } else {
    return date.getHours() + ":" + date.getMinutes();
  }
};

// let isMySelf = function (userName: string) {
//   return false;
// };
</script>

<style scoped lang="css">
.messageChatClass {
  width: 100%;
  height: 100%;
  background-color: #f5f5f5;
}

.header {
  height: 60px;
  padding: 20px 0 0 30px;
  box-sizing: border-box;
}

.friendName {
  font-size: 19px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.message-wrapper {
  min-height: 420px;
  max-height: 420px;
  padding: 0 15px 18px 15px;
  box-sizing: border-box;
  border-top: 1px solid #e7e7e7;
  border-bottom: 1px solid #e7e7e7;
}

/*.message-wrapper .more {*/
/*  text-align: center;*/
/*  color: #2c90ff;*/
/*  margin-top: 8px;*/
/*  font-size: 12px;*/
/*}*/

.message-wrapper .message-item {
  list-style: none;
  margin-top: 16px;
}

.message-wrapper .message-item .main .avatar {
  cursor: pointer;
  float: left;
  margin-left: 15px;
  border-radius: 3px;
}

.message-wrapper .message-item .main .text-msg {
  padding: 6px 10px;
  max-width: 330px;
  min-height: 36px;
  line-height: 24px;
  box-sizing: border-box;
  font-size: 14px;
  text-align: left;
  word-break: break-all;
  background-color: #ffffff;
  border: 1px solid #ececec;
  border-radius: 4px;
}

.message-wrapper .message-item .main .text-msg:hover {
  border: 1px solid #e7e7e7;
}

.message-wrapper .message-item .main .text-msg:before,
:after {
  position: absolute;
  display: block;
  width: 0;
  height: 0;
  content: "";
  border: solid transparent;
  border-right-color: #ffffff;
}

.message-wrapper .message-item .main .content {
  display: inline-block;
  margin-left: 10px;
  position: relative;
}

.message-wrapper .message-item .other .content:before {
  border-right-color: #e7e7e7;
  border-width: 6px;
  top: 11px;
  right: 100%;
}

.message-wrapper .message-item .other .content:after {
  top: 12px;
  border-right-color: #fff;
  border-width: 5px;
  right: 100%;
}

.message-wrapper .message-item .self {
  display: flex;
  flex-direction: row-reverse;
}

.message-wrapper .message-item .self .avatar {
  margin: 0 15px;
}

.message-wrapper .message-item .self {
  display: flex;
  flex-direction: row-reverse;
}

.message-wrapper .messageChatClass {
  margin-bottom: 15px;
}

.message-wrapper .time {
  width: 100%;
  font-size: 12px;
  margin-top: 7px;
  margin-bottom: 10px;
  text-align: center;
}

.message-wrapper .time span {
  display: inline-block;
  padding: 4px 6px;
  color: #fff;
  border-radius: 3px;
  background-color: #dcdcdc;
}
</style>
