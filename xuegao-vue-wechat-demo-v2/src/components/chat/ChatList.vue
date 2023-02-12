<template>
  <div class="msgList user-select-none">
    <ul>
      <template v-for="item in chatInfoList" :key="item.friendInfo.id">
        <li class="selectChat" @click="selectChat(item)">
          <div class="list-left">
            <img
              class="avatar"
              width="40"
              height="40"
              :alt="
                item.friendUser.friendNote === ''
                  ? item.friendInfo.nickname
                  : item.friendUser.friendNote
              "
              :src="item.friendInfo.avatar"
            />
          </div>
          <div class="list-right">
            <!--            聊天的人的备注  -->
            <p class="name">
              {{
                item.friendUser.friendNote === null ||
                item.friendUser.friendNote === ""
                  ? item.friendInfo.nickname
                  : item.friendUser.friendNote
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
import { isEmpty } from "@/common/ObjectUtil";
import { replaceToFaceByMsg } from "@/model/Emoji";
import { computed } from "vue";
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

let selectChatStore = useSelectChatStore();
let selectChatMessageStore = useSelectChatMessageStore();
// console.log("  chat list 进来了");

// 获取聊天列表的消息，最新的聊天消息在最上面
let chatInfoList = computed(() => {
  let tempChatInfoList = getChatInfoList();
  tempChatInfoList.sort(function (a, b) {
    return a.index - b.index;
  });
  // 根据时间进行排序，最新的时间在最上面
  // console.log("tempChatInfoV2List ", tempChatInfoList);
  // console.log("getSelectChat ", selectChatStore.action.getSelectChat);
  return tempChatInfoList;
});

// 每次选择chat聊天框的时候，都需要更新，当前选择的东西
let selectChat = function (chatInfo: ChatInfo) {
  // console.log(" selectChat input chatInfo = ", JSON.stringify(chatInfo));
  selectChatStore.action.updateSelectChat(chatInfo);

  let chatType = chatInfo.chatType;
  if (MsgSendTypeEnum.oneToOne === chatType) {
    let friendUserId = chatInfo.friendInfo?.id;
    let selectChatMessageBO: SelectChatMessageBO = {
      chatType: MsgSendTypeEnum.oneToOne,
    };
    if (friendUserId === "1") {
      selectChatMessageBO.friendMessageList = friendMessageList1To1List;
      selectChatMessageStore.action.updateSelectChatMessage(
        selectChatMessageBO
      );
    } else if (friendUserId === "2") {
      selectChatMessageBO.friendMessageList = friendMessageList1To2List;
      selectChatMessageStore.action.updateSelectChatMessage(
        selectChatMessageBO
      );
    } else if (friendUserId === "3") {
      selectChatMessageBO.friendMessageList = friendMessageList1To3List;
      selectChatMessageStore.action.updateSelectChatMessage(
        selectChatMessageBO
      );
    }
    // console.log(
    //   "chatList ",
    //   JSON.stringify(selectChatMessageStore.action.getState())
    // );
  }
};

// 将时间进行转换成 mm:ss
let getTimes = function (lastMsgTime: Date) {
  // console.log(" lastMsgTime ", lastMsgTime);
  if (isEmpty(lastMsgTime)) {
    return "";
  }
  if (lastMsgTime.getMinutes() < 10) {
    return lastMsgTime.getHours() + ":0" + lastMsgTime.getMinutes();
  } else {
    return lastMsgTime.getHours() + ":" + lastMsgTime.getMinutes();
  }
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
