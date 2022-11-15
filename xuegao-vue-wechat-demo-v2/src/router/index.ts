import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "index",
    component: () => import("@/service/index/view/XueGaoIndex.vue"),
    alias: ["/index"],
  },
  {
    path: "/system/login",
    name: "systemLogin",
    component: () => import("@/service/login/view/LoginAndRegister.vue"),
    meta: {
      //true 组件需要被缓存
      keepAlive: true,
      //用于判断上一个页面是哪个
      // isBack: false,
    },
  },
  {
    path: "/im/home",
    name: "imHome",
    component: () => import("@/service/home/view/ImHome.vue"),
    redirect: "/im/chat",
    children: [
      {
        path: "/im/chat",
        component: () => import("@/service/chat/view/ImChat.vue"),
      },
      {
        path: "/im/friend",
        component: () => import("@/service/friend/view/ImFriend.vue"),
      },
      {
        path: "/im/mark",
        component: () => import("@/service/mark/view/ImMark.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  // console.log("to = ", JSON.stringify(to));
  // console.log("from = ", JSON.stringify(from));
  // console.log("next = ", JSON.stringify(next));
  next();
});
export default router;
