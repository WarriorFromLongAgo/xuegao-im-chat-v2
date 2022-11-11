<template>
  <div class="search-list-wrapper">
    <div class="search-list">
      <i
        class="icon iconfont icon-search5"
        v-bind:class="{ 'icon-search-color': searchIconColor }"
      ></i>
      <!--    @focus   输入框 获得焦点-->
      <!--    @blur    输入框 失去焦点-->
      <!--    @keyup   输入框 获得输入-->
      <input
        type="text"
        class="searchInput"
        @focus="inputFocus"
        @blur="inputBlur"
        v-model="searchInputPlaceholder"
        @keyup="change"
        :placeholder="placeholder"
      />
      <div
        class="searchInput-delete"
        v-show="showDelete"
        @mousedown="del"
      ></div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { defineProps, ref } from "vue";

const parentProps = defineProps({
  placeholder: { type: String, required: true },
});

let searchInputPlaceholder = ref("");
let searchIconColor = ref(false);
let showDelete = ref(false);

let change = function () {
  console.log("change");
};

let inputFocus = function (e: PointerEvent) {
  console.log("inputFocus ", e);
  searchInputPlaceholder.value = "";
  searchIconColor.value = true;
  showDelete.value = true;
};

let inputBlur = function (e: PointerEvent) {
  console.log("inputBlur ", e);
  // e.target.placeholder = "搜索";
  searchInputPlaceholder.value = "搜索";
  searchIconColor.value = false;
  showDelete.value = false;
};

let del = function () {
  searchInputPlaceholder.value = "";
  console.log("del");
};
</script>

<style lang="css" scoped>
.search-list-wrapper {
  padding: 22px 12px 12px 12px;
  background-color: #f7f7f7;
  display: flex;
}

.search-list {
  position: relative;
  display: flex;
  box-sizing: border-box;
  height: 26px;
  width: 100%;
  background-color: #e2e2e2;
  border: 1px solid #e2e2e2;
  border-radius: 5px;
}

.search-list .searchInput {
  flex: 1;
  font-size: 12px;
  padding: 6px;
  background-color: #e2e2e2;
  outline: none;
}

.search-list .searchInput:focus {
  background-color: #f7f7f7;
}

.search-list .icon-search {
  display: inline-block;
  width: 24px;
  height: 24px;
  font-size: 14px;
  line-height: 24px;
  text-align: center;
  transform: rotateY(180deg);
}

.search-list .icon-search-color {
  background-color: #f7f7f7;
}

.search-list .searchInput-delete {
  display: block;
  position: absolute;
  outline: none;
  top: 0;
  right: 0;
  width: 24px;
  height: 100%;
  background-image: url("delete.png");
  background-size: 26px;
  background-position: center;
  background-repeat: no-repeat;
  cursor: pointer;
}
</style>
