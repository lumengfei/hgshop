package com.lumengjun.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.comm.HgShopConstant;
import com.lumengjun.hgshop.pojo.Cart;
import com.lumengjun.hgshop.pojo.Order;
import com.lumengjun.hgshop.pojo.User;
import com.lumengjun.hgshop.service.CartService;
import com.lumengjun.hgshop.service.OrderService;
import com.lumengjun.hgshop.service.User2Service;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Reference
	User2Service userService;
	
	@Reference
	CartService cartService;
	
	@Reference
	OrderService orderService;
	
	@RequestMapping("tologin")
	public String tologin(){
		return "user/login";
		
	}
	
	@RequestMapping("login")
	public String login(String username,String password,HttpServletRequest request){
		
		User user = userService.login(username,password);
		System.err.println(user);
		if(user == null){
			request.setAttribute("error", "用户名或密码错误");
			return "user/login";
		}
		request.getSession().setAttribute(HgShopConstant.USEKEY, user);
		return "redirect:/";
		
	}
	
	/**
	 * 进入注册的页面
	 * @return
	 */
	@RequestMapping("toRegister")
	public String toRegister() {
		return "user/register";
	}
	/**
	 * 接收用户注册提交的数据
	 * @param request
	 * @return
	 */
	@RequestMapping("register")
	public String login(HttpServletRequest request,User user) {
		// 注册
		System.err.println("11111111111111");
		User registerUser = userService.register(user);
		if(registerUser == null) {
			request.setAttribute("error", "注册失败");
			return "user/register";
		}
		//注册成功 跳转到登陆页面
		return "redirect:tologin";
	}
	
	/**
	 * 加入购物车
	 * @param skuId  
	 * @param buyNum 购买数量
	 * @return
	 */
	@RequestMapping("addCart")
	@ResponseBody
	public String addCart(HttpServletRequest request,
			int skuId, int buyNum) {
		
		//获取当前登录的用户
		User loginUser = (User)request.getSession().getAttribute(HgShopConstant.USEKEY);
		if(loginUser==null) {
			return  "亲，您尚未登录，不能加入购物车哦";
		}
		
		int result= cartService.addCart(loginUser.getUid(),skuId,buyNum);
		return result>0?"success":"添加失败";
	}
	
	/**
	 * 进入个人中心
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public String home(HttpServletRequest request) {
		return "user/index";
		
	}
	
	/**
	 * 
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping("cartlist")
	public String cartlist(HttpServletRequest request,
			@RequestParam(defaultValue="1") int page) {
		//获取当前登录的用户
		User loginUser = (User)request.getSession().getAttribute(HgShopConstant.USEKEY);
		if(loginUser==null) {
			request.setAttribute("error", "您尚未登陆");
			return "error";
		}
		PageInfo<Cart> cartList = cartService.list(loginUser.getUid(), page);
		request.setAttribute("pageInfo", cartList);
		return "user/cartlist";
		
	}
	
	/**
	 * 
	 * @param request
	 * @param cartIds 
	 * @param address  邮寄地址
	 * @return
	 */
	@RequestMapping(value="addorder",produces="text/html:charset=UTF-8;")
	@ResponseBody
	public String addorder(HttpServletRequest request,
			@RequestParam("cartIds[]") int[] cartIds,String address){
		//获取当前登录的用户
		User loginUser = (User)request.getSession().getAttribute(HgShopConstant.USEKEY);
		if(loginUser==null) {
			request.setAttribute("error", "您尚未登陆");
			return "error";
		}
		System.out.println("cartIds is " + cartIds);
		int result = cartService.createOrder(loginUser.getUid(),address, cartIds);
		return result>0?"success":"添加失败";
	}
	
	/**
	 * 
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping("orderlist")
	public String orderlist(HttpServletRequest request,
			@RequestParam(defaultValue="1") int page) {
		//获取当前登录的用户
		User loginUser = (User)request.getSession().getAttribute(HgShopConstant.USEKEY);
		if(loginUser==null) {
			request.setAttribute("error", "您尚未登陆");
			return "error";
		}
		PageInfo<Order> list = orderService.list(loginUser.getUid(), page);
		request.setAttribute("pageInfo", list);
		return "user/orderlist";
		
	}
	

}
