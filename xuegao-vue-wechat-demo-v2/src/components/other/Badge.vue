<!--<template>-->
<!--  <div-->
<!--    :style="{-->
<!--      width: getWidth + 'px',-->
<!--      height: getHeight + 'px',-->
<!--      right: '-' + getWidth / 2 + 'px',-->
<!--      top: '-' + getHeight / 2 + 'px',-->
<!--      borderRadius: getWidth + 'px',-->
<!--    }"-->
<!--    class="badge"-->
<!--  >-->
<!--    <span-->
<!--      v-if="showNum"-->
<!--      :style="{-->
<!--        width: getWidth + 'px',-->
<!--        height: getHeight + 'px',-->
<!--        lineHeight: getHeight + 'px',-->
<!--        transformOrigin: getWidth / 2 + 'px ' + getHeight / 2 + 'px',-->
<!--      }"-->
<!--    >-->
<!--      {{ getShowNum }}</span-->
<!--    >-->
<!--  </div>-->
<!--</template>-->

<!--<script lang="ts" setup>-->
<!--import { computed, defineProps, withDefaults } from "vue";-->

<!--interface ParentProps {-->
<!--  width: number;-->
<!--  height: number;-->
<!--  count: number;-->
<!--  overflowCount: number;-->
<!--  showNum: boolean;-->
<!--}-->

<!--// 当使用基于类型的声明时，我们失去了为 props 声明默认值的能力。这可以通过 withDefaults 编译器宏解决-->
<!--const props = withDefaults(defineProps<ParentProps>(), {-->
<!--  width: 16,-->
<!--  height: 16,-->
<!--  count: 0,-->
<!--  overflowCount: 99,-->
<!--  showNum: true,-->
<!--});-->

<!--// 对 defineProps() 的响应性解构-->
<!--// 默认值会被编译为等价的运行时选项-->
<!--// ESLint: Destructuring the `props` will cause the value to lose reactivity.(vue/no-setup-props-destructure)-->
<!--// const {-->
<!--//   width = 16,-->
<!--//   height = 16,-->
<!--//   count = null,-->
<!--//   overflowCount = 99,-->
<!--//   showNum = true,-->
<!--// } = defineProps<ParentProps>();-->

<!--const getWidth = computed<number>(() => {-->
<!--  if (!props.showNum) {-->
<!--    return 10;-->
<!--  }-->
<!--  let width = props.width;-->
<!--  if (props.count > 9 && props.count < 100) {-->
<!--    width = width + 4;-->
<!--  }-->
<!--  if (props.count > 99) {-->
<!--    width = width + 8;-->
<!--  }-->
<!--  return width;-->
<!--});-->

<!--const getHeight = computed<number>(() => {-->
<!--  if (!props.showNum) {-->
<!--    return 10;-->
<!--  }-->
<!--  return props.height;-->
<!--});-->

<!--const getShowNum = computed<number | string>(() => {-->
<!--  if (props.count > props.overflowCount) {-->
<!--    return props.overflowCount + "+";-->
<!--  }-->
<!--  return props.count;-->
<!--});-->
<!--</script>-->

<!--<style lang="css" scoped>-->
<!--.badge {-->
<!--  position: absolute;-->
<!--  background-color: #fa5151;-->
<!--  text-align: center;-->
<!--}-->

<!--.badge span {-->
<!--  display: inline-block;-->
<!--  font-size: 18px;-->
<!--  color: #fff;-->
<!--  /*-webkit-transform: scale(0.5);*/-->
<!--  transform: scale(0.5);-->
<!--  font-weight: 100;-->
<!--}-->
<!--</style>-->
