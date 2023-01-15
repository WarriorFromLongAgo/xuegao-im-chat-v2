import { readonly } from "vue";
import { createState } from "@/service/chat/store/SelectChatMessageBO";
import { createAction } from "@/service/chat/store/SelectChatMessageAction";

const state = createState();
const action = createAction(state);

export const useSelectChatMessageStore = () => {
  return {
    state: readonly(state),
    action: readonly(action),
  };
};
