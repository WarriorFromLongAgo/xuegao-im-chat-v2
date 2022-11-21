<template>
  <div class="content">
    <div class="msgList">
      <SearchInfo :placeholder="placeholder"></SearchInfo>
      <ChatList></ChatList>
    </div>
    <div class="chatBox">
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

let placeholder = "搜索";
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
