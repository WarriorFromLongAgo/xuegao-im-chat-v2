interface GenericModel {
  id: string;
  delFlag?: number;
  createdBy?: string;
  createdTime?: Date;
  updatedBy?: string;
  updatedTime?: Date;
  traceId?: string;
}

export { GenericModel };
