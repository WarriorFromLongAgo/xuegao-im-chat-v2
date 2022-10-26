import {isEmpty, isNotEmpty} from "@/common/objecs";

/**
 * @description 将base64转换为文件
 * @returns {Number}
 * @param dataUrl
 * @param fileName
 */
export const base64toFile = function (dataUrl: string, fileName: string): File | null {
    if (isEmpty(dataUrl) || isEmpty(fileName)) {
        return null
    }
    const arr: string [] = dataUrl.split(',')
    if (isEmpty(arr)) {
        return null
    }
    // eslint-disable-next-line @typescript-eslint/ban-ts-comment
    // @ts-ignore
    const mime = arr[0].match((/:(.*?);/))[1];
    // let mime2 = arr[0].match(/:(.*?);/)[1]
    const buster = atob(arr[1])
    let n = buster.length
    const u8arr = new Uint8Array(n);
    while (n--) {
        u8arr[n] = buster.charCodeAt(n);
    }
    // 后缀
    const suffix = "." + mime.split('/')[1];
    return new File([u8arr], fileName + suffix, {
        type: mime
    });
    ///return new Blob([u8arr], { type: mime });////blob
}
