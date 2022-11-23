import { createState } from "@/service/chat/store/SelectChatBO";
import { createAction } from "@/service/chat/store/SelectChatAction";
import { readonly } from "vue";

const state = createState();
const action = createAction(state);

export const useStore = () => {
  return {
    state: readonly(state),
    action: readonly(action),
  };
};
