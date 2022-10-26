<template>
  <div class="login">
    <div class="label"></div>
    <div class="header">
      <img id="headMenu" class="avatar" />
    </div>
    <div class="loginInfo">
      <input class="account" placeholder="昵称" />
      <input class="account" maxlength="14" placeholder="账号" />
    </div>
    <div class="loginButton" @click="login">
      <span>登录</span>
    </div>
  </div>
</template>

<script lang="ts" setup></script>

<!--<style lang="stylus" scoped>-->
<!--.fade-enter-active, .fade-leave-active {-->
<!--  transition: opacity 1s;-->
<!--}-->

<!--.fade-enter, .fade-leave-to {-->
<!--  opacity: 1s;-->
<!--}-->

<!--.login {-->
<!--  width: 280px;-->
<!--  height: 400px;-->
<!--  position: absolute;-->
<!--  top: 0;-->
<!--  right: 0;-->
<!--  bottom: 0;-->
<!--  left: 0;-->
<!--  margin: auto;-->
<!--  background-color: #F5F5F5;-->
<!--  border-radius: 3px;-->
<!--  text-align: center;-->

<!--  .header {-->
<!--    margin-top: 70px;-->
<!--    margin-bottom: 30px;-->

<!--    .avatar {-->
<!--      width: 80px;-->
<!--      height: 80px;-->
<!--      border-radius: 3px;-->
<!--    }-->
<!--  }-->

<!--  .loginInfo {-->
<!--    margin: 0 auto;-->

<!--    .account {-->
<!--      background-image: url('./account.svg');-->

<!--      &:focus {-->
<!--        background-image: url('./account-choice.svg');-->
<!--      }-->
<!--    }-->

<!--    .password {-->
<!--      background-image: url('./password.svg');-->

<!--      &:focus {-->
<!--        background-image: url('./password-choice.svg');-->
<!--      }-->
<!--    }-->

<!--    input {-->
<!--      font-size: 16px;-->
<!--      width: 135px;-->
<!--      padding: 4px 15px 4px 30px;-->
<!--      margin-bottom: 10px;-->
<!--      border-bottom: 1px solid #D6D6D6;-->
<!--      font-family: inherit;-->
<!--      overflow: hidden;-->
<!--      background-color: #F5F5F5;-->
<!--      background-repeat: no-repeat;-->
<!--      background-position: center;-->
<!--      background-position-x: 5px;-->
<!--      background-size: 15px 15px;-->

<!--      &:focus {-->
<!--        border-bottom-color: #1aad19;-->
<!--        outline: 0;-->
<!--        // -webkit-box-shadow: inset 0 1px 1px rgba(26,173,25,.075),0 0 8px rgba(26,173,25,.6)-->
<!--        // box-shadow: inset 0 1px 1px rgba(26,173,25,.075),0 0 8px rgba(26,173,25,.6)-->
<!--      }-->
<!--    }-->
<!--  }-->

<!--  .select {-->
<!--    margin-top: 5px;-->
<!--  }-->

<!--  .loginButton {-->
<!--    margin: 0 auto;-->
<!--    margin-top: 35px;-->
<!--    width: 180px;-->
<!--    height: 40px;-->
<!--    line-height: 40px;-->
<!--    font-size: 14px;-->
<!--    color: #fff;-->
<!--    background-color: #1aad19;-->
<!--    cursor: pointer;-->
<!--    border-radius: 1px;-->

<!--    &:hover {-->
<!--      background: rgb(18, 150, 17);-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</style>-->
