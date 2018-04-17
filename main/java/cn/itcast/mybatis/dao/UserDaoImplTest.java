package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {

        String resource = "sqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);


    }

    @Test
    public void findUserById() throws Exception {

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        User user = userDao.findUserById(1);

        System.out.println(user);

    }
}