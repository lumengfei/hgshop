package com.lumengjun.hgshop.dao;

import java.util.List;

import com.lumengjun.hgshop.pojo.Spu;
import com.lumengjun.hgshop.pojo.SpuVo;

public interface SpuMapper {

	List<Spu> list(SpuVo vo);

	Spu findById(int id);

	int deleteSpuBatch(int[] ids);

	int delete(int id);

	int update(Spu spu);

	int add(Spu spu);

	

}
