package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

import java.util.List;

public interface OrdersMapperCustom {



    public List<OrdersCustom> findOrdersUser() throws Exception;


//    使用resultmap

    public List<Orders> findOrdersUserResultMap() throws Exception;

    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    public List<User>  findUserAndItems() throws Exception;
}

