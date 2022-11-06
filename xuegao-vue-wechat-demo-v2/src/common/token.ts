import { isNotBlank } from "@/util/ObjectUtil";

export const TOKEN_KEY = "token";

export const removeToken = () => {
  localStorage.removeItem(TOKEN_KEY);
};

export const setToken = (token: string) => {
  localStorage.setItem(TOKEN_KEY, token);
};

export const hasToken = () => {
  const token: string | null = localStorage.getItem(TOKEN_KEY);
  return isNotBlank(token);
};
