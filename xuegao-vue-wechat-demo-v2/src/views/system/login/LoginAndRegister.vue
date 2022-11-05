<template>
  <div class="container" id="container">
    <div class="form-container">
      <div class="sign-up-container">
        <form action="">
          <div class="header">
            <img id="avatar" :src="avatar" class="avatar" />
          </div>
          <input class="register-username" type="text" placeholder="登录账号" />
          <input class="register-password" type="password" placeholder="密码" />
          <input
            class="register-enter-password"
            type="password"
            placeholder="确认密码"
          />
          <!--          <router-view :to="{ name: 'imHome' }">-->
          <button type="button" class="register-btn" @click="systemRegister">
            注册
          </button>
          <!--          </router-view>-->
          <!--          <div class="register-tips">tips：昵称可以在登录后随便修改</div>-->
        </form>
      </div>
      <div class="sign-in-container">
        <form action="">
          <div class="header">
            <img id="avatar" :src="avatar" class="avatar" />
          </div>
          <input
            class="login-username"
            type="text"
            placeholder="账号/昵称/邮箱"
          />
          <!-- <input type="email" placeholder="Email" /> -->
          <input class="login-password" type="password" placeholder="密码" />
          <div class="remember-me">
            <input type="checkbox" /><span>记住我</span>
          </div>
          <button type="button" class="login-btn" @click="systemLogin">
            登录
          </button>
          <!--        <div class="login-other-operate">-->
          <!--          <a href="#">忘记密码</a> |-->
          <!--          <a href="#">注册新账号</a>-->
          <!--        </div>-->
        </form>
      </div>
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

<script setup lang="ts">
import router from "@/router";
import localAvatar1 from "/public/static/images/avatar1.png";
import localAvatar2 from "/public/static/images/avatar2.png";
import { isNavigationFailure, NavigationFailureType } from "vue-router";

let avatar = localAvatar1;
let avatar2 = localAvatar2;

function systemRegister() {
  router.push({ name: "imHome", replace: true });
}

function systemLogin() {
  let failure = router.push({ path: "/im/home" });
  console.log("systemLogin = ", JSON.stringify(failure));
  // .then((failure) => {
  // if (isNavigationFailure(failure, NavigationFailureType.)) {
  //   failure.to.path; // '/admin'
  //   failure.from.path; // '/'
  // }
  // });
  // if (isNavigationFailure(failure, NavigationFailureType.aborted)) {
  //   // 给用户显示一个小通知
  //   console.log("systemLogin aborted = ", failure);
  // }
  // if (isNavigationFailure(failure, NavigationFailureType.cancelled)) {
  //   // 给用户显示一个小通知
  //   console.log("systemLogin cancelled = ", failure);
  // }
  // if (isNavigationFailure(failure, NavigationFailureType.duplicated)) {
  //   // 给用户显示一个小通知
  //   console.log("systemLogin duplicated = ", failure);
  // }
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

.form-container {
  display: flex;
  width: 560px;
  height: 400px;

  border-style: solid;
  border-width: 1px;
  border-color: transparent;
  background-color: #f5f5f5;
  border-radius: 3px;
}

.sign-up-container,
.sign-in-container {
  width: 50%;
  height: 100%;
}

.form-container form {
  display: flex;
  /* 一列的展示 */
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;

  width: 100%;
  height: 100%;

  text-align: center;
}

.form-container .header {
  margin-top: 70px;
  margin-bottom: 30px;
}

.form-container .header .avatar {
  width: 80px;
  height: 80px;
  border-radius: 3px;
}

.register-username,
.login-username {
  background-image: url("./account.svg");
}

.register-username,
.login-username {
  background-image: url("./account-choice.svg");
}

.register-password,
.register-enter-password,
.login-password {
  background-image: url("./password.svg");
}

.register-password:focus,
.register-enter-password:focus,
.login-password:focus {
  background-image: url("./password-choice.svg");
}

input {
  font-size: 16px;
  width: 135px;
  padding: 4px 15px 4px 30px;
  margin-bottom: 10px;
  border: 1px solid transparent;
  border-bottom: 1px solid #d6d6d6;
  font-family: inherit;
  overflow: hidden;
  background-color: #f5f5f5;
  background-repeat: no-repeat;
  background-position: center;
  background-position-x: 5px;
  background-size: 15px 15px;
}

input:focus {
  border-bottom-color: #1aad19;
  outline: 0;
}

.register-btn,
.login-btn {
  border: 1px solid transparent;
  margin: 10px auto 0;
  width: 180px;
  height: 40px;
  line-height: 40px;
  font-size: 14px;
  color: #fff;
  background-color: #1aad19;
  cursor: pointer;
  border-radius: 1px;
}

.register-btn:hover,
.login-btn:hover {
  background: rgb(18, 150, 17);
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
