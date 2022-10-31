import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "index",
    component: () => import("@/views/system/index/XuegaoIndex.vue"),
    alias: ["/index"],
  },
  {
    path: "/system/login",
    name: "systemLogin",
    component: () => import("@/views/system/login/LoginAndRegister.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
