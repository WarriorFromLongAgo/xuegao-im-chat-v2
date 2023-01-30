import { readonly } from "vue";
import { createState } from "@/common/ws/store/wsBO";
import { createAction } from "@/common/ws/store/wsAction";

const state = createState();
const action = createAction(state);

export const useWsStore = () => {
  return {
    state: readonly(state),
    action: readonly(action),
  };
};
