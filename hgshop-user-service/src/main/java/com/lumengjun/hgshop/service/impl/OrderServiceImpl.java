package com.lumengjun.hgshop.service.impl;

import java.util.List;








import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;







import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.dao.OrderMapper;
import com.lumengjun.hgshop.pojo.Order;
import com.lumengjun.hgshop.pojo.OrderDetail;
import com.lumengjun.hgshop.service.OrderService;


/**
 * 
 * @author AUSU
 *
 */
@Service(interfaceClass=OrderService.class)
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderMapper orderMapper;

	@Override
	public PageInfo<Order> list(int userId, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		
		return new PageInfo<Order>(orderMapper.list(userId));
	}

	@Override
	public List<OrderDetail> listDetail(int orderId, int page) {
		// TODO Auto-generated method stub
		return orderMapper.listDetail(orderId);
	}
	
}
