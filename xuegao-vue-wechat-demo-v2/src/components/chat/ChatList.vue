<template>
  <div class="msgList user-select-none">
    <ul v-if="refreshFlag">
      <template v-for="item in refChatInfoList" :key="item.index">
        <li class="selectChat" @click="selectChat(item)">
          <div class="list-left">
            <img
              class="avatar"
              width="40"
              height="40"
              :alt="
                item.friendUser?.friendNote === ''
                  ? item.friendInfo?.nickname
                  : item.friendUser?.friendNote
              "
              :src="item.friendInfo?.avatar"
            />
          </div>
          <div class="list-right">
            <!--            聊天的人的备注  -->
            <p class="name">
              {{
                item.friendUser === null ||
                item.friendUser?.friendNote === null ||
                item.friendUser?.friendNote === ""
                  ? item.friendInfo?.nickname
                  : item.friendUser?.friendNote
              }}
            </p>
            <!--            朋友之间聊天的最后一条消息 的发送时间-->
            <span class="time" v-text="getTimes(item.lastMsgTime)"></span>
            <!--            朋友之间聊天的最后一条消息-->
            <p
              class="lastMsg"
              v-html="replaceToFaceByMsg(item.lastFriendMessage)"
            ></p>
          </div>
        </li>
      </template>
    </ul>
  </div>
</template>

<script lang="ts" setup>
import { isBlank } from "@/common/ObjectUtil";
import { replaceToFaceByMsg } from "@/model/Emoji";
import { computed, onBeforeMount, reactive, ref } from "vue";
import { useSelectChatStore } from "@/service/chat/store/SelectChatStore";
import { ChatInfo, getChatInfoList } from "@/model/BO/ChatInfo";
import { useSelectChatMessageStore } from "@/service/chat/store/SelectChatMessageStore";
import {
  friendMessageList1To1List,
  friendMessageList1To2List,
  friendMessageList1To3List,
} from "@/model/temp/FriendMessageListData";
import { SelectChatMessageBO } from "@/service/chat/store/SelectChatMessageBO";
import { MsgSendTypeEnum } from "@/model/Enum/MsgSendTypeEnum";
import { listChatInfoHttp } from "@/service/home/call/call/ChatListCallV2";
import { useChatInfoListStore } from "@/service/chat/store/ChatInfoListStore";
import { listSelectChatMsgListHttp } from "@/service/chat/call/SelectChatMsgList";

let refreshFlag = ref<boolean>(true);

console.log(" chatList onBeforeCreate ");
let refChatInfoList = reactive<Array<ChatInfo>>([]);
// refChatInfoList.push(chatInfoOne);
// let chatInfoListPromise = listChatInfoHttp();

// chatInfoListPromise.then(
//   function (value) {
//     console.log(" onBeforeCreate chatInfoList ", JSON.stringify(value));
//     useChatInfoListStore().action.updateChatInfoList(value);
//     console.log(" onBeforeCreate refChatInfoList 1 ", refChatInfoList);
//     refChatInfoList = value;
//     console.log(" onBeforeCreate refChatInfoList 2 ", refChatInfoList);
//   },
//   function (error) {
//     // 把这个函数作为promise对象状态变为失败后调用的回调函数
//     // 失败时的逻辑
//     console.log(" error ");
//   }
// );

// 获取聊天列表的消息，最新的聊天消息在最上面
// let chatInfoList: Array<ChatInfo> = reactive([]);
//
onBeforeMount(async () => {
  console.log(" chatList onBeforeMount ");
  let chatInfoList = await listChatInfoHttp();
  console.log(" chatList onBeforeMount ", JSON.stringify(chatInfoList));
  useChatInfoListStore().action.updateChatInfoList(chatInfoList);
  console.log(" refChatInfoList 1 ", refChatInfoList);
  // refChatInfoList = chatInfoList;
  chatInfoList.forEach((value) => {
    refChatInfoList.push(value);
  });
  console.log(" refChatInfoList 2 ", refChatInfoList);

  // refreshFlag.value = false;
  // console.log(" refreshFlag 1 ");
  // refreshFlag.value = true;
  // console.log(" refreshFlag 2 ");
});

let chatInfoListComputedV1 = computed(() => {
  let tempChatInfoList = getChatInfoList();
  // 根据时间进行排序，最新的时间在最上面
  console.log("chatInfoListComputedV1 ", tempChatInfoList);
  // console.log(
  //   "getSelectChat ",
  //   JSON.stringify(selectChatStore.action.getSelectChat())
  // );
  return tempChatInfoList;
});

// 获取聊天列表的消息，最新的聊天消息在最上面
let chatInfoListComputedV2 = computed(() => {
  // let tempChatInfoList = getChatInfoList();
  let resultChatInfoList: Array<ChatInfo> = [];
  let tempChatInfoListPromise: Promise<Array<ChatInfo>> = listChatInfoHttp();
  // eslint-disable-next-line vue/no-async-in-computed-properties
  tempChatInfoListPromise
    .then((res) => {
      resultChatInfoList = res;
    })
    .catch((err) => {
      console.log("tempChatInfoListPromise ", err);
    });
  // tempChatInfoList.sort(function (a, b) {
  //   return a.index - b.index;
  // });
  // 根据时间进行排序，最新的时间在最上面
  console.log("resultChatInfoList ", resultChatInfoList);
  // console.log(
  //   "getSelectChat ",
  //   JSON.stringify(selectChatStore.action.getSelectChat())
  // );
  return resultChatInfoList;
});

let chatInfoListStateV1 = computed(() => {
  let tempChatInfoList = useChatInfoListStore().action.chatInfoList();
  console.log(" chatInfoListStateV1 ", JSON.stringify(tempChatInfoList));
  return tempChatInfoList;
});

// 每次选择chat聊天框的时候，都需要更新，当前选择的东西
let selectChat = async function (chatInfo: ChatInfo) {
  // console.log(" selectChat input chatInfo = ", JSON.stringify(chatInfo));
  useSelectChatStore().action.updateSelectChat(chatInfo);

  let chatType = chatInfo.chatType;
  if (MsgSendTypeEnum.oneToOne === chatType) {
    let friendUserId = chatInfo.friendInfo?.id;

    let msgListHttp = await listSelectChatMsgListHttp(friendUserId as string);
    console.log("selectChat msgListHttp ", msgListHttp);
    let selectChatMessageBO: SelectChatMessageBO = {
      chatType: MsgSendTypeEnum.oneToOne,
      friendMessageList: msgListHttp,
    };
    useSelectChatMessageStore().action.updateSelectChatMessage(
      selectChatMessageBO
    );

    // if (friendUserId === "1") {
    //   selectChatMessageBO.friendMessageList = friendMessageList1To1List;
    //   useSelectChatMessageStore().action.updateSelectChatMessage(
    //     selectChatMessageBO
    //   );
    // } else if (friendUserId === "2") {
    //   selectChatMessageBO.friendMessageList = friendMessageList1To2List;
    //   useSelectChatMessageStore().action.updateSelectChatMessage(
    //     selectChatMessageBO
    //   );
    // } else if (friendUserId === "3") {
    //   selectChatMessageBO.friendMessageList = friendMessageList1To3List;
    //   useSelectChatMessageStore().action.updateSelectChatMessage(
    //     selectChatMessageBO
    //   );
    // }
    // console.log(
    //   "chatList ",
    //   JSON.stringify(selectChatMessageStore.action.getState())
    // );
  }
};

// 将时间进行转换成 mm:ss
let getTimes = function (lastMsgTimeStr: string) {
  // console.log(" lastMsgTimeStr input ", lastMsgTimeStr);
  if (isBlank(lastMsgTimeStr)) {
    return "";
  }
  let lastMsgTime = new Date(Date.parse(lastMsgTimeStr));
  let resultStr = "";
  try {
    if (lastMsgTime.getMinutes() < 10) {
      resultStr = lastMsgTime.getHours() + ":0" + lastMsgTime.getMinutes();
    } else {
      resultStr = lastMsgTime.getHours() + ":" + lastMsgTime.getMinutes();
    }
  } catch (e) {
    console.log(" getTimes resultStr error ", lastMsgTime, e);
  }
  return resultStr;
};
</script>

<style lang="css" scoped>
.msgList {
  width: 100%;
  height: 570px;
}

.selectChat {
  display: flex;
  padding: 12px;
  transition: background-color 0.1s;
  font-size: 0;
}

.selectChat:hover {
  display: flex;
  padding: 12px;
  background-color: rgb(220, 220, 220);
}

.selectChat:active {
  display: flex;
  padding: 12px;
  background-color: rgb(196, 196, 196);
}

.selectChat .list-left {
  position: relative;
  margin-right: 12px;
}

.selectChat .list-left .avatar {
  border-radius: 2px;
}

.selectChat .list-right {
  position: relative;
  flex: 1;
  margin-top: 4px;
}

.selectChat .list-right .name {
  display: inline-block;
  vertical-align: top;
  font-size: 14px;
}

.selectChat .list-right .time {
  float: right;
  color: #999;
  font-size: 10px;
  vertical-align: top;
}

.selectChat .list-right .lastMsg {
  position: absolute;
  font-size: 12px;
  width: 130px;
  height: 15px;
  line-height: 15px;
  color: #999;
  bottom: 0;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
