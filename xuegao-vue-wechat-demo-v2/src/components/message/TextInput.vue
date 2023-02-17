<template>
  <div class="text">
    <div
      id="textarea"
      class="textarea"
      contenteditable="true"
      ref="sendText"
      @paste="pasteListener($event)"
      @keydown.delete="backspaceKeyDownListener($event)"
      @keydown.enter="enterKeyDownListener($event)"
    ></div>
    <div class="send" @click="sendMsg">
      <span>发送(S)</span>
    </div>
    <transition name="appear">
      <div class="warn" v-show="alertWarnMsgFlag">
        <div class="description">不能发送空白信息</div>
      </div>
    </transition>
  </div>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import { isBlank, isEmpty } from "@/common/ObjectUtil";
import { useWsStore } from "@/common/ws/store/wsStore";
import { useSelectChatMessageStore } from "@/service/chat/store/SelectChatMessageStore";
import { useSelectChatStore } from "@/service/chat/store/SelectChatStore";
import CommonMsgBO from "@/model/BO/CommonMsgBO";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";

let alertWarnMsgFlag = ref(false);
const sendText = ref<HTMLTextAreaElement>();

// ctrl + v  ClipboardEvent
let pasteListener = function (e: ClipboardEvent) {
  console.log(" pasteListener 粘贴板事件  ", e);
};

// 监听回退按键
let backspaceKeyDownListener = function (e: PointerEvent) {
  console.log(" backspaceListener ");
};

// 按回车发送信息
let enterKeyDownListener = function onkeydown(e: KeyboardEvent) {
  console.log(" enterKeyDownListener ", e);
  sendMsg();
};

let sendMsg = function () {
  let value: HTMLTextAreaElement = sendText.value as HTMLTextAreaElement;
  // if (value === undefined) {
  //   value = window.document.createElement("textarea");
  // }
  // console.log(" sendMsg value = ", value);
  let textAreaText = value.innerHTML;
  // console.log(" innerHTML textAreaText = ", textAreaText);
  if (isBlank(textAreaText)) {
    alertWarnMsgFlag.value = true;
    // 一秒钟后消息
    setTimeout(() => {
      alertWarnMsgFlag.value = false;
    }, 1000);
    return;
  } else {
    alertWarnMsgFlag.value = false;
  }

  let chatType = useSelectChatStore().action.getChatType();
  if (chatType === undefined) {
    throw new Error("chatType is null");
  }
  const sendMsg: CommonMsgBO = {
    messageType: chatType,
    content: textAreaText,
  };
  useWsStore().action.sendMsg(JSON.stringify(sendMsg));
  value.innerHTML = "";
};
</script>

<style scoped lang="css">
.text {
  position: relative;
  background: #fff;
}

.text .send {
  position: absolute;
  cursor: pointer;
  bottom: 10px;
  right: 30px;
  width: 75px;
  height: 28px;
  line-height: 28px;
  box-sizing: border-box;
  text-align: center;
  border: 1px solid #e5e5e5;
  border-radius: 3px;
  background: #f5f5f5;
  font-size: 14px;
  color: #7c7c7c;
}

.text .send:hover {
  background: rgb(18, 150, 17);
  color: #fff;
}

.text .warn {
  position: absolute;
  bottom: 50px;
  right: 10px;
  width: 110px;
  height: 30px;
  line-height: 30px;
  font-size: 12px;
  text-align: center;
  border: 1px solid #bdbdbd;
  border-radius: 4px;
  box-shadow: 0 1px 5px 1px #bdbdbd;
}

.warn.appear-enter-active,
.warn.appear-leave-active {
  transition: all 1s;
}

.warn.appear-enter,
.warn.appear-leave-active {
  transition: all 1s;
}

.warn:before {
  content: " ";
  position: absolute;
  top: 100%;
  right: 20px;
  border: 7px solid transparent;
  border-top-color: #fff;
  filter: drop-shadow(1px 3px 2px #bdbdbd);
}

#textarea {
  box-sizing: border-box;
  padding-left: 30px;
  height: 110px;
  width: 690px;
  border: none;
  outline: none;
  overflow-y: scroll;
  font-family: "Micrsofot Yahei";
  resize: none;
}
</style>
