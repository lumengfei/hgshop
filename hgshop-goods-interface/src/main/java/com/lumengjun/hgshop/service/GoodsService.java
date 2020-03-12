package com.lumengjun.hgshop.service;

import java.util.List;









import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.pojo.Brand;
import com.lumengjun.hgshop.pojo.CallBack;
import com.lumengjun.hgshop.pojo.Category;
import com.lumengjun.hgshop.pojo.Sku;
import com.lumengjun.hgshop.pojo.Spu;
import com.lumengjun.hgshop.pojo.SpuVo;

/**
 * 
 * @author ASUS
 ***** Dubbo 服务接口函数比要有非Void 的返回值********
 */
public interface GoodsService {
	/**
	 * 添加品牌
	 * @param brand
	 * @return
	 */
	CallBack addBrand(Brand brand);
	/**
	 * 根据id 查询一条品牌  用于修改回显
	 * @param id
	 * @return
	 */
	Brand findById(Integer id); 

	/**
	 * 修改品牌
	 * @param brand
	 * @return
	 */
	CallBack updateBrand(Brand brand);
	
	/**
	 * 根据id 删除一条品牌
	 * @param id
	 * @return
	 */
	CallBack deleteBrand(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Brand> listBrand( String first,int page); 
	List<Brand> getAllBrands();
	/**
	 * 添加分类
	 * @param category
	 * @return
	 */
	CallBack addCategory(Category category);
	
	/**
	 * 修改分类
	 * @param category
	 * @return
	 */
	CallBack updateCategory(Category category);
	/**
	 * 删除分类
	 * @param id
	 * @return
	 */
	CallBack deleteCategory(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Category> listCategory( String firstChar,int page); 
	
	/**
	 * 以树的形式显示列表
	 * @return
	 */
	List<Category> treeCategory();
	
	
		// spu的管理
		PageInfo<Spu>  listSpu(int page,SpuVo vo);
		CallBack addSpu(Spu spu);
		CallBack updateSpu(Spu spu);
		CallBack deleteSpu(int id);
		Spu getSpu(int id);
		CallBack deleteSpuBatch(int[] id);
		
		
		 
		// sku的管理
		PageInfo<Sku>  listSku(int page,Sku sku);
		CallBack addSku(Sku sku);
		Sku getSku(int id);//获取详情
		CallBack updateSku(Sku sku);
		CallBack deleteSku(int id);
		CallBack deleteSkuBatch(int[] id);
		
		//查询商品详情
		List<Sku> listSkuBySpu(int spuId);
		

		
	

}
