package com.cl.dao;

import com.cl.entity.YundongjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YundongjiluView;


/**
 * 运动记录
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:23
 */
public interface YundongjiluDao extends BaseMapper<YundongjiluEntity> {
	
	List<YundongjiluView> selectListView(@Param("ew") Wrapper<YundongjiluEntity> wrapper);

	List<YundongjiluView> selectListView(Pagination page,@Param("ew") Wrapper<YundongjiluEntity> wrapper);
	
	YundongjiluView selectView(@Param("ew") Wrapper<YundongjiluEntity> wrapper);
	

}
