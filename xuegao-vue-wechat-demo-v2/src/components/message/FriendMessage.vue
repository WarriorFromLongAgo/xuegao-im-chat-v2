<template>
  <div class="messageChatClass">
    <header class="header user-select-none">
      <div class="friendName">
        <!--        <span style="cursor: pointer" @click="showChatInfo">{{-->
        <!--          item.friendInfo.remark === ""-->
        <!--            ? item.friendInfo.nickname-->
        <!--            : item.friendInfo.remark-->
        <!--        }}</span>-->
        <span style="cursor: pointer" @click="showChatInfo"
          >item.friendInfo.remark</span
        >
      </div>
      <!--      <i-->
      <!--        style="cursor: pointer"-->
      <!--        @click="showChatInfo"-->
      <!--        class="icon iconfont icon-more info"-->
      <!--      ></i>-->
    </header>
    <!--      @mousewheel="mousewheel"-->
    <div class="message-wrapper scrollbar" @scroll="handleScroll" ref="list">
      <!--v-if="selectedChat"-->
      <ul>
        <li v-for="item in showMessageList" class="message-item" :key="item.id">
          <div class="time selectNone">
            <span v-if="item.showTime">{{ convertToTime(item.date) }}</span>
          </div>
          <div
            class="main"
            :class="{
              self: isMySelf(item.username),
              other: !isMySelf(item.username),
            }"
          >
            <div
              class="text"
              v-if="item.type === 1"
              v-html="replaceFace(item)"
            ></div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { onMounted, ref } from "vue";
import { getMessageInfoList, MessageInfo } from "@/model/MessageInfo";
import { replaceFace } from "@/model/Emoji";

let showMessageList = ref<Array<MessageInfo>>(new Array<MessageInfo>());

let showChatInfo = function () {
  console.log("  showChatInfo ");
};
// let mousewheel = function () {
//   console.log("  mousewheel ");
// };
let handleScroll = function () {
  console.log("  showChatInfo ");
  // this.$parent.showChatInfo();
};

let convertToTime = function (date: Date) {
  if (date.getMinutes() < 10) {
    return date.getHours() + ":0" + date.getMinutes();
  } else {
    return date.getHours() + ":" + date.getMinutes();
  }
};

let isMySelf = function (userName: string) {
  // return userName === user.username
  return false;
};

onMounted(() => {
  console.log(" onMounted ");
  for (const messageInfo of getMessageInfoList()) {
    showMessageList.value.push(messageInfo);
  }
  console.log(" onMounted ", JSON.stringify(showMessageList));
});
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

.message-wrapper .more {
  text-align: center;
  color: #2c90ff;
  margin-top: 8px;
  font-size: 12px;
}

.message-wrapper .message-item {
  margin-top: 16px;
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
