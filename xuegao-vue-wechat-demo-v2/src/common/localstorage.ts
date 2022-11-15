// class LocalCache {
//   // 添加
//   setCache(key: string, value: string) {
//     localStorage.setItem(key, value);
//   }
//
//   // 查找
//   getCache(key: string) {
//     // obj=>sting=>obj
//     const value = localStorage.getItem(key);
//     if (value) {
//       return JSON.parse(value);
//     }
//   }
//
//   // 删除
//   deleteCache(key: string) {
//     localStorage.removeItem(key);
//   }
//
//   // 清理
//   clearCache() {
//     localStorage.clear();
//   }
// }
//
// export default new LocalCache();
