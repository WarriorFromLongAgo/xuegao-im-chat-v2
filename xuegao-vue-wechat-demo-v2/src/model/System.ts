// 聊天会话 列表

import {Emoji} from "@/model/Emoji";

export interface System {
    windowWidth: number,
    windowHeight: number,
    imgWindow: ImgWindow,
    network: boolean,
    headMenu: HeadMenu,
    // 系统图标
    systemFileIcon: string,
    // 输入的搜索值
    searchText: string,
    emojis: Array<Emoji>,
}

export interface ImgWindow {
    width: number,
    height: number,
    showImgWindow: boolean,
    src: string | null
}

export interface HeadMenu {
    visibleIng: boolean,
    visible: boolean,
    clientX: number,
    clienty: number,
    self: boolean,
    //类型 1 好友 2 群聊,
    type: number
}
