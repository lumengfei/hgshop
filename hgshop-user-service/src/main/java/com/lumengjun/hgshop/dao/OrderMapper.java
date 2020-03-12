package com.lumengjun.hgshop.dao;

import java.util.List;

import com.lumengjun.hgshop.pojo.Order;
import com.lumengjun.hgshop.pojo.OrderDetail;

public interface OrderMapper {

	int add(Order order);

	int addDetail(OrderDetail orderDetail);

	List<Order> list(int userId);

	List<OrderDetail> listDetail(int orderId);

}
