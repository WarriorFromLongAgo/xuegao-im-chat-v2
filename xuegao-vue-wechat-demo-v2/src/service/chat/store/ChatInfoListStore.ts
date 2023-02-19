import { readonly } from "vue";
import { createState } from "@/service/chat/store/ChatInfoListBO";
import { createAction } from "@/service/chat/store/ChatInfoListAction";

const state = createState();
const action = createAction(state);

export const useChatInfoListStore = () => {
  return {
    state: readonly(state),
    action: readonly(action),
  };
};
