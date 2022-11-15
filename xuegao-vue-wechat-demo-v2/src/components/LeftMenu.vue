<template>
  <div class="leftMenu user-select-none">
    <header>
      <img
        @click.prevent="openUserInfo($event)"
        :src="localAvatar1"
        class="avatar"
        alt=""
      />
    </header>
    <!-- 导航栏，分布了三个功能，聊天消息，好友，收藏 -->
    <div class="navbar" @click="clearSearch">
      <!--      第一个，点击进入聊天消息-->
      <router-link
        to="/im/chat"
        class="icon iconfont icon-wechat2"
      ></router-link>
      <!--      第二个，点击进入 好友-->
      <router-link to="/im/friend" class="icon iconfont icon-friends_add">
      </router-link>
      <!--      第二个，点击进入 收藏-->
      <router-link
        to="/im/mark"
        class="icon iconfont icon-shoucang-"
      ></router-link>
    </div>
    <footer>
      <!--      设置按钮-->
      <i class="icon iconfont icon-shezhi"></i>
    </footer>
  </div>
</template>

<script lang="ts" setup>
import localAvatar1 from "/public/static/images/avatar1.png";

console.log("LeftMenu");

let openUserInfo = function (e: PointerEvent) {
  console.log("openMenu e", e);
};

let clearSearch = function () {
  console.log(" clearSearch ");
};
</script>

<style lang="css" scoped>
.leftMenu {
  position: relative;
  width: 100%;
  height: 100%;
}

.avatar {
  cursor: pointer;
  width: 37px;
  height: 37px;
  margin: 25px 9px 0 9px;
}

.navbar {
  width: 100%;
  text-align: center;
}

.navbar .icon {
  display: inline-block;
  font-size: 19px;
  margin-top: 28px;
  padding: 0 18px;
  box-sizing: border-box;
  color: rgb(151, 151, 151);
  cursor: pointer;
}

.navbar .icon:active {
  background-color: #fa5151;
  color: rgb(0, 220, 65);
}
/*.router-link-active {*/
/*  color: rgb(0, 220, 65);*/
/*}*/

.navbar .icon:hover {
  opacity: 1;
  color: rgb(163, 163, 163);
  /*background-color: brown;*/
}

.icon-wechat2,
.icon-friends_add,
.icon-shoucang- {
  font-size: 18px;
}

.icon-wechat2,
.icon-friends_add {
  position: relative;
  padding: 0 19px;
}

/*.badge {*/
/*  right: 8px !important;*/
/*}*/

footer {
  position: absolute;
  bottom: 20px;
  width: 100%;
  text-align: center;
}
</style>
