interface GenericModelDTO<T> {
  addList?: Array<T>;
  updateList?: Array<T>;
  enableList?: Array<T>;
  disableList?: Array<T>;
  deleteList?: Array<T>;
  vo?: T;
  id?: string;
  ids?: Array<string>;
  // 页码
  page: 1;
  // 每页记录数
  pageSize: 10;
}

export { GenericModelDTO };
