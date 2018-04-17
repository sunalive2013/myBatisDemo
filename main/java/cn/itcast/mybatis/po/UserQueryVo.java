package cn.itcast.mybatis.po;

import java.util.List;

public class UserQueryVo {

//传入多个id
    private List<Integer> ids;

//    包装所需要的查询条件
//
//    包括：用户的查询条件

    private  UserCustom userCustom;


    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
//    商品查询条件

}
