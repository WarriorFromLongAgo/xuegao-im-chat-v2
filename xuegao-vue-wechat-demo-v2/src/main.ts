import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "./assets/css/common.css";
import "@/assets/icons/iconfont.css";

const app = createApp(App);
app.use(router);
app.mount("#app");
