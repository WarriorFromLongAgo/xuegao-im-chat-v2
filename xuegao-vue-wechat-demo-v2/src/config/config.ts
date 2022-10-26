const apiUrl: string = process.env.VUE_APP_API_HOST;
const wsUrl: string = process.env.VUE_WS_URL;
const publicPath: string = process.env.PUBLIC_PATH;

enum ENV {
  DEV = "dev",
  PRD = "prd",
}

let NOW_ENV: string = ENV.DEV;

switch (process.env.NODE_ENV) {
  case "development":
    console.log("[xuegao-vue-wechat-demo-ts][config.ts][env=development]");
    if (apiUrl === undefined) {
      throw new Error("apiUrl === undefined");
    }
    if (wsUrl === undefined) {
      throw new Error("wsUrl === undefined");
    }
    if (publicPath === undefined) {
      throw new Error("publicPath === undefined");
    }
    NOW_ENV = ENV.DEV;
    break;
  case "production":
    console.log("[xuegao-vue-wechat-demo-ts][config.ts][env=production]");
    NOW_ENV = ENV.PRD;
    break;
}

export default {
  useI18n: false,
  publicPath: publicPath,
  now_env: NOW_ENV,
  wsUrl: wsUrl,
  apiUrl: apiUrl,
};
