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

        List<User> userList = ordersMapperCustom.findUserAndItems();

        System.out.println(userList);

        sqlSession.close();

    }



    /*
    * 查询订单关联用户，用户信息需要延时加载
    *
    * 测试思路
    * 1、执行mapper方法（findOrdersUserLazyLoading），只查询orders信息（单标）
    *
    * 2、在程序中去遍历上一步查出的List<Orders>，当我们调用Orders中的getUser方法，
    * 进行延时加载
    *
    * 3、延时加载，去掉用UserMapper.xml中findUserById这个方法获取用户信息
    *
    * */
    @Test
    public void testFindOrdersUserLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom =
                sqlSession.getMapper(OrdersMapperCustom.class);

        // 只查询orders信息（单标）
        List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();

        // d调用调用Orders中的getUser方法获得用户列表
        // 调用UserMapper.xml中findUserById这个方法获取用户信息
        for (Orders order : list ){

            // 执行getUser（）去查询用户信息，实现按需加载
            User user = order.getUser();
            System.out.println(user);
        }

        sqlSession.close();

    }
}