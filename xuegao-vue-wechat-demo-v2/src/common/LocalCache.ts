import { getDate, getTime } from "@/common/time";

export { LocalCacheUtil };
// sda
class localCacheValue {
  value: string;
  expire?: number;
  saveTime: Date;

  constructor(value: string, expire: number, saveTime: Date) {
    this.expire = expire;
    this.value = value;
    this.saveTime = saveTime;
  }
}

class LocalCacheUtil {
  expire(key: string, value: string, expire: number) {
    const tempValue: localCacheValue = {
      value: value,
      expire: expire,
      saveTime: getDate(),
    };
    localStorage.setItem(key, JSON.stringify(tempValue));
  }

  set(key: string, value: string) {
    const tempValue: localCacheValue = {
      value: value,
      saveTime: getDate(),
    };
    localStorage.setItem(key, JSON.stringify(tempValue));
  }

  remove(key: string) {
    localStorage.removeItem(key);
  }

  clear() {
    localStorage.clear();
  }

  get(key: string) {
    const item: string | null = localStorage.getItem(key);
    if (!item) {
      return null;
    }
    const newItem: localCacheValue = JSON.parse(item);
    if (
      newItem.expire &&
      newItem.expire < getTime() - newItem.saveTime.getTime()
    ) {
      this.remove(key);
      return null;
    } else {
      return newItem.value;
    }
  }
}
