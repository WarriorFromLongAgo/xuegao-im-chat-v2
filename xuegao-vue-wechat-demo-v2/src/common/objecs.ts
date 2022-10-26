/**
 * 判断为空
 */
export const isEmpty = (value: unknown) =>
    value === null ||
    value === undefined ||
    value === '' ||
    value === {} ||
    value === [];
/**
 * 判断不为空
 */
export const isNotEmpty = (value: unknown) => !isEmpty(value);
/**
 * 去除空格
 */
export const trim = (value: string): string => {
    if (isEmpty(value)) {
        return ""
    }
    return value.trim()
}
