import { readonly } from "vue";
import { createAction } from "@/service/login/store/LoginInfoAction";
import { createState } from "@/service/login/store/LoginInfo";

const state = createState();
const action = createAction();

export const useLoginStore = () => {
  return {
    state: readonly(state),
    action: readonly(action),
  };
};
