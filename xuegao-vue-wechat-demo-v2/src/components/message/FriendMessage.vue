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
              self: isMySelf(item.userId),
              other: !isMySelf(item.userId),
            }"
          >
            <div
              class="text"
              v-if="ChatMsgTypeEnum.Text === item.messageType"
              v-html="replaceToFaceByMsg(item)"
            ></div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { computed, onMounted, ref } from "vue";
import { replaceToFaceByMsg } from "@/model/Emoji";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { useSelectChatMessageStore } from "@/service/chat/store/SelectChatMessageStore";
let selectChatMessageStore = useSelectChatMessageStore();

// 获取聊天记录
let selectChatFriendMessageList = computed(() => {
  return selectChatMessageStore.action.getFriendMessageList();
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

let isMySelf = function (userName: string) {
  return false;
};

// 页面初始化完毕，调用一次
onMounted(() => {
  console.log(
    " onMounted ",
    JSON.stringify(selectChatMessageStore.action.getState())
  );
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
