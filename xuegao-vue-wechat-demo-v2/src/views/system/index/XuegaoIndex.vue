<template>
  <div class="container" id="container">
    <!--    <div class="top-bar-wrapper">-->
    <!--      <div class="top-bar">-->
    <!--        <div class="to-github">-->
    <!--          <a href="https://github.com/WarriorFromLongAgo/xuegao-im-chat-v2">-->
    <!--          </a>-->
    <!--        </div>-->
    <!--      </div>-->
    <!--    </div>-->
    <div class="show-tips">
      {{ showTips }}
    </div>
    <div class="to-url">
      <button class="to-login" type="button" @click="toLoginVue">
        点击进入雪糕家
      </button>
      <!--      <input type="button" class="to-login" value="点击进入雪糕家" />-->
    </div>
    <footer>
      <p>
        Created with by
        <a href="https://github.com/WarriorFromLongAgo/xuegao-im-chat-v2">
          github</a
        >
      </p>
    </footer>
  </div>
</template>

<!--<script lang="js">-->
<!--export default {-->
<!--  name: "XuegaoIndex",-->
<!--  inheritAttrs: false,-->
<!--  customOptions: {},-->
<!--};-->
<!--</script>-->

<script lang="ts" setup>
import { computed } from "vue";
import router from "@/router";

let showTips = computed(() => {
  return "雪糕家是一个开源的web即时通讯系统";
});

/**
 * 跳转页面
 * */
function toLoginVue() {
  router.push({ path: "/system/login" });
  // router.push({ name: "systemLogin" });
}
</script>

<style lang="css" scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  /*align-content: center;*/
  flex-direction: column;

  height: 100vh;
  width: 100vw;
  background: url(../../../../public/static/images/bg.png);
  background-size: cover;
}

.show-tips {
  font-weight: bold;
}

.to-url {
  display: flex;
  height: 36px;
  margin-top: 10px;
  text-align: center;
  line-height: 20px;
}

.to-url button {
  background-color: transparent;
  /*border-style: none;*/

  border: 1px solid;
  border-radius: 15px;
  /*!* 上下左右的填充 *!*/
  padding: 1px 10px;
  font-weight: bold;
  transition: transform 80ms ease-in;
}

.to-url button:hover {
  border-color: white;
}

.to-url button:active {
  border-color: white;
  transform: scale(1.1);
}

footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  padding: 10px 0 10px 0;
  text-align: center;

  /*background-color: rgb(83, 104, 123);*/
  background-color: #222;

  /* 文字的相关属性 */
  color: white;
  font-size: 14px;
}

footer a {
  color: #3c97bf;
  text-decoration: underline;
}
</style>
