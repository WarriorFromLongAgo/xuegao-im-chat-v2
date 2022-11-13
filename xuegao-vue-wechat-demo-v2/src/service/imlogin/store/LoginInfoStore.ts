import { readonly } from "vue";
import { createAction } from "@/service/imlogin/store/LoginInfoAction";
import { createState } from "@/service/imlogin/store/LoginInfo";

const state = createState();
const action = createAction(state);

export const useLoginStore = () => {
  return {
    state: readonly(state),
    action: readonly(action),
  };
};
