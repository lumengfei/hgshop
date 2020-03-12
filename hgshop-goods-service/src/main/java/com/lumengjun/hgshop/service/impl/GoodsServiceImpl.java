package com.lumengjun.hgshop.service.impl;

import java.util.List;























import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.dao.BrandMapper;
import com.lumengjun.hgshop.dao.CategoryMapper;
import com.lumengjun.hgshop.dao.SkuMapper;
import com.lumengjun.hgshop.dao.SpuMapper;
import com.lumengjun.hgshop.pojo.Brand;
import com.lumengjun.hgshop.pojo.CallBack;
import com.lumengjun.hgshop.pojo.Category;
import com.lumengjun.hgshop.pojo.Sku;
import com.lumengjun.hgshop.pojo.SpecOption;
import com.lumengjun.hgshop.pojo.Spu;
import com.lumengjun.hgshop.pojo.SpuVo;
import com.lumengjun.hgshop.service.GoodsService;

/**
 * 
 * @author ASUS
 *
 */
@Service(interfaceClass=GoodsService.class)
public class GoodsServiceImpl  implements GoodsService{

	@Autowired
	CategoryMapper categoryMapper;
	
	@Autowired
	BrandMapper brandMapper;
	
	@Autowired
	SpuMapper spuMapper;
	
	@Autowired
	SkuMapper skuMapper;
	
	@Override
	public CallBack addBrand(Brand brand) {
		try {
			brandMapper.addBrand(brand);
		} catch (Exception e) {
			return new CallBack(2, "添加失败", "");
		}
		return new CallBack(1, "", "添加成功");
	}

	@Override
	public CallBack updateBrand(Brand brand) {
		try {
			brandMapper.updateBrand(brand);
		} catch (Exception e) {
			return new CallBack(2, "修改失败", "");
		}
		return new CallBack(1, "", "修改成功");
	}

	@Override
	public CallBack deleteBrand(Integer id) {
		try {
			brandMapper.updateBrandById(id);
		} catch (Exception e) {
			return new CallBack(2, "删除失败", "");
		}
		return new CallBack(1, "", "删除成功");
	}

	@Override
	public PageInfo<Brand> listBrand(String first, int page) {
		PageHelper.startPage(page, 3);
		List<Brand> list = brandMapper.listBrand(first);
		return new PageInfo<Brand>(list);
	}

	@Override
	public CallBack addCategory(Category category) {
		try {
			categoryMapper.addCategory(category);
		} catch (Exception e) {
			return new CallBack(2, "添加失败", "");
		}
		return new CallBack(1, "", "添加成功");
	}

	@Override
	public CallBack updateCategory(Category category) {
		try {
			categoryMapper.updateCategory(category);
		} catch (Exception e) {
			return new CallBack(2, "修改失败", "");
		}
		return new CallBack(1, "", "修改成功");
	}
	

	@Override
	public CallBack deleteCategory(Integer id) {
		try {
			categoryMapper.deleteCategory(id);
		} catch (Exception e) {
			return new CallBack(2, "删除失败", "");
		}
		return new CallBack(1, "", "删除成功");
	}

	@Override
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.tree();
	}

	@Override
	public Brand findById(Integer id) {
		
		return brandMapper.findById(id);
	}

	@Override
	public PageInfo<Spu> listSpu(int page, SpuVo vo) {
		PageHelper.startPage(page, 10);
		
		return new PageInfo<Spu>(spuMapper.list(vo));
	}

	@Override
	public CallBack addSpu(Spu spu) {
		// TODO Auto-generated method stub
		 try {
			spuMapper.add(spu);
		} catch (Exception e) {
			return new CallBack(2, "失败", "");
		}
		//kafaTemplate.send("MyAddSpu", "spuId", cnt+"");
		 return new CallBack(1, "", "成功");
		 
	}

	@Override
	public CallBack updateSpu(Spu spu) {
		// TODO Auto-generated method stub
		 try {
			 spuMapper.update(spu);
			} catch (Exception e) {
				return new CallBack(2, "失败", "");
			}
			//kafaTemplate.send("MyAddSpu", "spuId", cnt+"");
			 return new CallBack(1, "", "成功");
	}

	@Override
	public CallBack deleteSpu(int id) {
		// TODO Auto-generated method stub
		
		 try {
			 spuMapper.delete(id);
			} catch (Exception e) {
				return new CallBack(2, "失败", "");
			}
			//kafaTemplate.send("MyAddSpu", "spuId", cnt+"");
			 return new CallBack(1, "", "成功");
	}

	@Override
	public CallBack deleteSpuBatch(int[] ids) {
		// TODO Auto-generated method stub
		
		 try {
			 spuMapper.deleteSpuBatch(ids);
			} catch (Exception e) {
				return new CallBack(2, "失败", "");
			}
			//kafaTemplate.send("MyAddSpu", "spuId", cnt+"");
			 return new CallBack(1, "", "成功");
	}

	@Override
	public Spu getSpu(int id) {
		// TODO Auto-generated method stub
		return spuMapper.findById(id);
	}

	@Override
	public List<Brand> getAllBrands() {
	
		return brandMapper.listAll();
	}

	@Override
	public PageInfo<Sku> listSku(int page, Sku sku) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		return new PageInfo<Sku>(skuMapper.list(sku));
	}

	@Override
	public CallBack addSku(Sku sku) {
		try {
			int cnt = skuMapper.addSku(sku);
			System.err.println(cnt);
			List<SpecOption> specs = sku.getSpecs();
			for (SpecOption specOption : specs) {
				cnt += skuMapper.addSkuSpec(sku.getId(),specOption);
			}
		} catch (Exception e) {
			return new CallBack(2, "失败", "");
		}
		//kafaTemplate.send("MyAddSpu", "spuId", cnt+"");
		 return new CallBack(1, "", "成功");
	}

	@Override
	public Sku getSku(int id) {
		// TODO Auto-generated method stub
		return skuMapper.get(id);
	}

	@Override
	public CallBack updateSku(Sku sku) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallBack deleteSku(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallBack deleteSkuBatch(int[] id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sku> listSkuBySpu(int spuId) {
		// TODO Auto-generated method stub
		return skuMapper.listBySpu(spuId);
	}

}
