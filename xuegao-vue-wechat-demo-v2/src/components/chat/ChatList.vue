<template>
  <div class="msgList user-select-none">
    <ul>
      <template v-for="item in chatInfoV2List" :key="item.friendInfo.id">
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
import { ChatInfoData, getChatInfoV2List } from "@/model/temp/ChatInfoData";
import { ChatMsgTypeEnum } from "@/model/Enum/ChatMsgTypeEnum";
import { useStore } from "@/service/chat/store/SelectChatStore";

// let loginStore = useLoginStore();
// let sysUser = loginStore.action.getSysUser();
let selectChatUseStore = useStore();

console.log("  chat list 进来了");

let chatInfoV2List = computed(() => {
  return getChatInfoV2List();
});

let selectChat = function (chatInfoData: ChatInfoData) {
  console.log(" selectChat input chatInfoData = ", chatInfoData);
  let selectChatState = selectChatUseStore.state;
  selectChatUseStore.action.updateChatType(ChatMsgTypeEnum.OneToOne);

  // let chatMsgTypeEnum = chatInfoData.chatType;
  // if (ChatMsgTypeEnum.OneToOne === chatMsgTypeEnum) {
  //   if (
  //     chatInfoData.friendInfo === undefined ||
  //     chatInfoData.friendUser === undefined
  //   ) {
  //     throw new Error("选择朋友信息为空");
  //   }
  //   selectChatMethod.updateByFriend(
  //     chatInfoData.friendInfo,
  //     chatInfoData.friendUser
  //   );
  // } else if (ChatMsgTypeEnum.ManyToMany === chatMsgTypeEnum) {
  //   if (
  //     chatInfoData.groupInfo === undefined ||
  //     chatInfoData.groupUser === undefined
  //   ) {
  //     throw new Error("选择朋友信息为空");
  //   }
  //   selectChatMethod.updateByGroup(
  //     chatInfoData.groupInfo,
  //     chatInfoData.groupUser
  //   );
  // }
  // console.log(
  //   "selectChat finally selectChat = ",
  //   selectChatMethod.getSelectChat()
  // );
};

let getTimes = function (lastMsgTime: Date) {
  console.log(" lastMsgTime ", lastMsgTime);
  if (isEmpty(lastMsgTime)) {
    return "";
  }
  if (lastMsgTime.getMinutes() < 10) {
    return lastMsgTime.getHours() + ":0" + lastMsgTime.getMinutes();
  } else {
    return lastMsgTime.getHours() + ":" + lastMsgTime.getMinutes();
  }
};

let consoleLog = function (msg: string, info: any) {
  console.log(msg + " = ", info);
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
