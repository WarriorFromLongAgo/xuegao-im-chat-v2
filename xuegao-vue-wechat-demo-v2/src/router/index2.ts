// import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'
// import {getToken} from "@/common/token";
//
// const routes: Array<RouteRecordRaw> = [
//     {
//         path: '/login',
//         name: 'login',
//         component: () => import('@/page/login/Login.vue')
//     },
//     {
//         path: "/",
//         component: () => import('@/page/wechat/Wechat.vue'),
//         redirect: '/chat',
//         children: [{
//             path: '/chat',
//             component: () => import('@/page/chat/Chat.vue')
//         },
//             {
//                 path: '/friend',
//                 component: () => import('@/page/friend/Friend.vue')
//             },
//             {
//                 path: '/game',
//                 component: () => import('@/page/game/Game.vue')
//             }
//         ]
//     }
// ]
//
// const router = createRouter({
//     history: createWebHistory(process.env.BASE_URL),
//     routes,
//     linkActiveClass: 'active',
// })
//
// router.beforeEach((to, from, next) => {
//     const token = getToken();
//     if (to.path == "/login") {
//         if (token) {
//             next("/");
//         } else {
//             next();
//         }
//     } else {
//         if (token) {
//             if (to.path === '') {
//                 next("/chat");
//             } else {
//                 next();
//             }
//         } else {
//             next("/login");
//         }
//     }
// })
//
// export default router
