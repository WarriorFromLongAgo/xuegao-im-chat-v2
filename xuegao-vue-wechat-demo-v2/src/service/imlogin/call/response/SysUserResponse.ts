interface ISysUserResp {
  sysUser: ISysUser;
  token: string;
}

interface ISysUser {
  username: string;
  nickname: string;
  uid: string;
}

export { ISysUserResp, ISysUser };
