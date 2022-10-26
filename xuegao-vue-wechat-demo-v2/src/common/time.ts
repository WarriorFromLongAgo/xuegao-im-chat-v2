/**
 * @description 获取两个时间的相距多少分钟
 * @returns {Number}
 * @param startDate
 * @param endDate
 */
export const getMinute = function (startDate: Date, endDate: Date) {
    const diff = endDate.getTime() - startDate.getTime(); //时间差的毫秒数
    //计算出相差天数
    // var days=Math.floor(diff/(24*3600*1000));

    //计算出小时数
    const leave1 = diff % (24 * 3600 * 1000); //计算天数后剩余的毫秒数
    const hours = Math.floor(leave1 / (3600 * 1000));
    //计算相差分钟数
    const leave2 = leave1 % (3600 * 1000); //计算小时数后剩余的毫秒数
    const minutes = Math.floor(leave2 / (60 * 1000));

    //计算相差秒数
    // var leave3=leave2%(60*1000);      //计算分钟数后剩余的毫秒数
    // var seconds=Math.round(leave3/1000);

    if (minutes > 0) {
        return minutes;
    }
    return 0;
}


//从1970年开始的毫秒数然后截取10位变成 从1970年开始的秒数
export const getTimestamp = function (): number {
    return getDate().getTime();
}

export const getDate = function () {
    return new Date();
}
