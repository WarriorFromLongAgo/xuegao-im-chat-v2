<template>
  <div class="content">
    <div class="msgList">
      <SearchInfo :placeholder="placeholder"></SearchInfo>
      <ChatList></ChatList>
    </div>
    <div class="chatBox" v-if="getSelectChatFlag">
      <MessageChat class="message"></MessageChat>
      <TextInput class="text"></TextInput>
    </div>
  </div>
</template>

<script lang="ts" setup>
import SearchInfo from "@/components/search/SearchInfo.vue";
import ChatList from "@/components/chat/ChatList.vue";
import MessageChat from "@/components/message/MessageChat.vue";
import TextInput from "@/components/message/TextInput.vue";
import { useSelectChatStore } from "@/service/chat/store/SelectChatStore";
import { computed } from "vue";
import { isNotEmpty } from "@/common/ObjectUtil";

// console.log(" im chat 进来了");
let selectChatStore = useSelectChatStore();
let placeholder = "搜索";

// 如果已经选择了聊天，那么就展示聊天框，
// 否则展示微信的图标
let getSelectChatFlag = computed(() => {
  let tempSelectChat = selectChatStore.action.getSelectChat;
  // console.log("getSelectChat ", selectChatStore.action.getSelectChat);
  // 如果不为空，那么就是有值，代表已经选择了数据
  let selectChatFlag = isNotEmpty(tempSelectChat.chatType);
  // console.log(" getSelectChatFlag ", selectChatFlag);
  return selectChatFlag;
});
</script>

<style lang="css" scoped>
.content {
  display: flex;
  width: 100%;
}

.msgList {
  width: 250px;
  background: #e6e6e6;
  border-right: 1px solid #d6d6d6;
}
</style>
