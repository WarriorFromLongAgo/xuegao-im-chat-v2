<template>
  <div class="container" id="container">
    <div id="wechat" class="wechat">
      <div class="sidebar">
        <LeftMenu></LeftMenu>
      </div>
      <div class="main">
        <div class="systemBottom">
          <i class="icon iconfont icon-pin"></i>
          <i class="icon iconfont icon-zuixiaohua"></i>
          <i class="icon iconfont icon-zuidahua"></i>
          <i @click="systemExit" class="icon iconfont icon-close"></i>
        </div>
        <div class="routerViewDiv">
          <router-view></router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import LeftMenu from "@/components/LeftMenu.vue";
import router from "@/router";
import { useLoginStore } from "@/service/login/store/LoginInfoStore";
import { LocalCacheUtil } from "@/common/LocalCache";
import { useWsStore } from "@/common/ws/store/wsStore";
import { onBeforeMount, onMounted } from "vue";
import initWebSocket from "@/common/ws/ws";
import { getUserByTokenHttp } from "@/service/home/call/call/HomeCallV2";
import { HeaderToken, HeaderUserInfo } from "@/common/AxiosConstant";
import { SysUserBO } from "@/model/BO/SysUserBO";

onBeforeMount(() => {
  initWebSocket();
});

onMounted(async () => {
  let getUserByTokenHttpResp: SysUserBO = await getUserByTokenHttp();
  // console.log(
  //   " getUserByTokenHttp getUserByTokenHttpResp ",
  //   JSON.stringify(getUserByTokenHttpResp)
  // );
  useWsStore().action.bindSession(getUserByTokenHttpResp);
});

function systemExit() {
  let localCacheUtil = new LocalCacheUtil();
  localCacheUtil.remove(HeaderToken);

  localCacheUtil.remove(HeaderUserInfo.userId);
  localCacheUtil.remove(HeaderUserInfo.username);
  localCacheUtil.remove(HeaderUserInfo.userNumber);
  localCacheUtil.remove(HeaderUserInfo.nickname);
  localCacheUtil.remove(HeaderUserInfo.phone);
  localCacheUtil.remove(HeaderUserInfo.ipAdder);
  useWsStore().action.closeWs();
  router.replace({
    path: "/",
  });
}
</script>

<style lang="css" scoped>
.container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;

  height: 100vh;
  width: 100vw;
  background: url(../../../../public/static/images/bg.png);
  background-size: cover;
}

.wechat {
  position: absolute;
  display: flex;
  width: 1018px;
  height: 630px;
  background-color: #fff;
}

.wechat .sidebar {
  width: 55px;
  height: 630px;
  background: #2e2e2e;
}

.wechat .main {
  height: 630px;
  background: #f5f5f5;
  width: 100%;
}

.wechat .systemBottom {
  position: absolute;
  /*窗口缩小，这里也跟着变了*/
  /*left: 70%;*/
  /*left: 1317px;*/
  right: 0;

  height: 29px;
  width: 128px;
}

.wechat .systemBottom i {
  font-size: 6px !important;
  padding: 8px 10px;
  cursor: pointer;
  color: #7f7f7f;
}

.wechat .systemBottom i:hover {
  background-color: #e5e5e5;
  color: #3f3f3f;
}

.wechat .systemBottom .icon-close:hover {
  background-color: #fa5151;
  color: #fff;
}

/*.wechat .routerViewDiv {*/
/*  display: flex;*/
/*  !*width: 100%;*!*/
/*  !*height: 100%;*!*/
/*}*/
</style>
