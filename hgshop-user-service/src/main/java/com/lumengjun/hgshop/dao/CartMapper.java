package com.lumengjun.hgshop.dao;

import java.util.List;

import com.lumengjun.hgshop.pojo.Cart;

public interface CartMapper {

	int addCart(Cart cart);

	int delete(int[] ids);

	int clear(int uid);

	List list(int uid);

	List<Cart> listByIds(int[] cartIds);

	void deleteByIds(int[] cartIds);

}
