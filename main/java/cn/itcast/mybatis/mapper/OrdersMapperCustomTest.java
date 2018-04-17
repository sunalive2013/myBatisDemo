package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrdersMapperCustomTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void SetUp() throws IOException {
        String resouce = "sqlMapConfig.xml";

        InputStream in = Resources.getResourceAsStream(resouce);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void findOrdersUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom =
                sqlSession.getMapper(OrdersMapperCustom.class);

        List<OrdersCustom> ordersCustoms = ordersMapperCustom.findOrdersUser();

        System.out.println(ordersCustoms);

        sqlSession.close();

    }


    @Test
    public void findOrdersUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom =
                sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> orders = ordersMapperCustom.findOrdersUserResultMap();

        System.out.println(orders);

        sqlSession.close();

    }

    @Test
    public void findOrdersAndOrderDetailResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom =
                sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> orders = ordersMapperCustom.findOrdersAndOrderDetailResultMap();

        System.out.println(orders);

        sqlSession.close();

    }
//    findUserAndItems

    @Test
    public void findUserAndItems() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom =
                sqlSession.getMapper(OrdersMapperCustom.class);

        List<User> orders = ordersMapperCustom.findUserAndItems();

        System.out.println(orders);

        sqlSession.close();

    }
}