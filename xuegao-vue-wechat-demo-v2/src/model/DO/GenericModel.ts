interface GenericModel {
  id: string;
  delFlag?: number;
  createdBy?: string;
  createdTime?: Date;
  updatedBy?: string;
  updatedTime?: string;
  traceId?: string;
}

export { GenericModel };
