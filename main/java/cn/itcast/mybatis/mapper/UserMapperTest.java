package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {

        String resource = "sqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);


    }
    @Test
    public void findByUserId() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();


//         生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findByUserId(31);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void findUserByName() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();


//         生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findUserByName("赵丽洁");

        System.out.println(userList);

        sqlSession.close();

    }

    @Test
    public void findUserList() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();


//         生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        ids.add(31);

        //使用动态sql
//        userCustom.setSex("0");
//        userCustom.setUsername("赵丽洁");

        userQueryVo.setUserCustom(userCustom);
        userQueryVo.setIds(ids);

        List<UserCustom> userList = userMapper.findUserList(userQueryVo);

        System.out.println(userList);

        sqlSession.close();

    }


    @Test
    public void findUserByHashmap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();


        Map userMap = new HashMap();
        userMap.put("0","赵丽洁");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserByHashmap(userMap);

        System.out.println(user);

        sqlSession.close();

    }


    @Test
    public void findUserCount() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

//         生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("0");
        userCustom.setUsername("赵丽洁");
        userQueryVo.setUserCustom(userCustom);

        int count = userMapper.findUserCount(userQueryVo);

        System.out.println(count);


        sqlSession.close();
    }


    @Test
    public void findUserByResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();


//         生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserByResultMap(31);

        System.out.println(user);

        sqlSession.close();

    }
}