<template>
  <div class="text">
    <div
      id="textarea"
      class="textarea"
      contenteditable="true"
      ref="text"
      @onpaste="pasteListener($event)"
      @keydown.delete="backspaceKeyDownListener($event)"
      @keydown.enter="enterKeyDownListener($event)"
      @paste="pasteListener"
    ></div>
    <div class="send" @click="sendMsg">
      <span>发送(ent)</span>
    </div>
    <transition name="appear">
      <div class="warn" v-show="alertWarnMsgFlag">
        <div class="description">不能发送空白信息</div>
      </div>
    </transition>
  </div>
</template>

<script lang="ts" setup>
let alertWarnMsgFlag = false;
let pasteListener = function (e: PointerEvent) {
  console.log(" 粘贴板事件  ");
};

// 监听回退按键
let backspaceKeyDownListener = function (e: PointerEvent) {
  console.log(" backspaceListener ");
};

// 按回车发送信息
let enterKeyDownListener = function onkeydown(e: PointerEvent) {
  // if (e.ctrlKey && e.keyCode == 13) {
  // } else {
  //   send();
  //   e.preventDefault();
  // }
  console.log(" enterKeyDownListener ");
};

let sendMsg = function () {
  console.log(" sendMsg ");
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
