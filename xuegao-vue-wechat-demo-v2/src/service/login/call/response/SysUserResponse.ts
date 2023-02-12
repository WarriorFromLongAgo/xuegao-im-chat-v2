interface ISysUserResp {
  sysUser: ISysUser;
  token: string;
}

interface ISysUser {
  id: string;
  username: string;
  userNumber: string;
  nickname: string;
  uid: string;
}

export { ISysUserResp, ISysUser };
