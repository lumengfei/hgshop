package com.lumengjun.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.dao.SpecMapper;
import com.lumengjun.hgshop.pojo.CallBack;
import com.lumengjun.hgshop.pojo.Spec;
import com.lumengjun.hgshop.pojo.SpecOption;
import com.lumengjun.hgshop.service.SpecService;
/**
 * 规格的规律
 * @author ASUS
 *
 */
@Service(interfaceClass=SpecService.class)
public class SpecServiceImpl implements SpecService{

	@Autowired
	SpecMapper specMapper;
	
	@Override
	public PageInfo<Spec> list(String name, int page) {
		//进行分页
		PageHelper.startPage(page, 3);
		return new PageInfo<Spec>(specMapper.list(name));
	}

	@Override
	public int addSpec(Spec spec) {
		
		//添加主表
		specMapper.addSpec(spec);
		//这里可以返回主键
		//添加子表
		
		List<SpecOption> options = spec.getOptions();
		//添加规格的属性
		int n=1;
		for (SpecOption specOption : options) {
			specOption.setSpecId(spec.getId());
			specMapper.addOption(specOption);
			n++;
		}
		
		return n;
	}

	@Override
	public CallBack update(Spec spec) {
		try {
			specMapper.deleteSpecOution(spec.getId());
			specMapper.updateSpec(spec);
			List<SpecOption> options = spec.getOptions();
			//添加规格的属性
			for (SpecOption specOption : options) {
				specOption.setSpecId(spec.getId());
				specMapper.addOption(specOption);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new CallBack(2,"修改失败", "");
		}
		// TODO Auto-generated method stub
		return new CallBack(1, "", "修改成功");
	}

	@Override
	public CallBack delete(int id) {
		
		try {
			specMapper.deleteSpecOution(id);
			specMapper.deleteSpec(id);
		} catch (Exception e) {
			
			return new CallBack(2,"删除失败", "");
		}
		
		return new CallBack(1,"", "删除成功");
	}

	@Override
	public Spec findById(int id) {
		// TODO Auto-generated method stub
		return specMapper.findById(id);
	}

	@Override
	public CallBack deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		try {
			specMapper.deleteSpecOutionBatch(ids);
			
			specMapper.deleteSpecBatch(ids);
			
	} catch (Exception e) {
		
		return new CallBack(2,"删除失败", "");
	}
	
	return new CallBack(1,"", "删除成功");
	}

	@Override
	public List<Spec> listAll() {
		
		return specMapper.list("");
	}

}
