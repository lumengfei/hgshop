package com.lumengjun.hgshop.service;

import java.util.List;






import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.pojo.Order;
import com.lumengjun.hgshop.pojo.OrderDetail;

/**
 * 订单的服务
 * @author AUSU
 *
 */
public interface OrderService {

	
	/**
	 * 查看订单
	 * @param userId
	 * @param page
	 * @return
	 */
	PageInfo<Order> list(int userId,int page);
	
	/**
	 * 查看订单详情
	 * @param orderId
	 * @param page
	 * @return
	 */
	List<OrderDetail> listDetail(int orderId,int page);
	
	
	
	

}
