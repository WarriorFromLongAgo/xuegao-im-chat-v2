function isBlank(input: string | null): boolean {
  return (
    input === null || input === undefined || input === "" || input.trim() === ""
  );
}

function isNotBlank(input: string | null): boolean {
  return !isBlank(input);
}

function isEmpty(input: object | null | number): boolean {
  if (input === null || input == undefined) {
    return true;
  }
  // if (input instanceof String){
  //   return input === null || input == undefined || input === "" || input.trim() == ""
  // }
  if (input instanceof Array) {
    return input.length === 0;
  }
  if (input instanceof Map) {
    return input.size === 0;
  }
  if (input instanceof Set) {
    return input.size === 0;
  }
  return false;
}

function isNotEmpty(input: object | null | number): boolean {
  return !isEmpty(input);
}

/**
 * 去除空格
 */
const strTrim = (value: string): string => {
  if (isBlank(value)) {
    return "";
  }
  return value.trim();
};

export { isBlank, isNotBlank, isEmpty, isNotEmpty, strTrim };
