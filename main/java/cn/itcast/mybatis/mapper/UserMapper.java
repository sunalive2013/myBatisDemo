package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {



    public User findByUserId(int id) throws Exception;

    List<User> findUserByName(String username) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;

    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;


    public User findUserByHashmap(Map userMap) throws Exception;

    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    public  User findUserByResultMap(int id) throws Exception;
}
