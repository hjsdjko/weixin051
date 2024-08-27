package com.cl.dao;

import com.cl.entity.YundongtuijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YundongtuijianView;


/**
 * 运动推荐
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:25
 */
public interface YundongtuijianDao extends BaseMapper<YundongtuijianEntity> {
	
	List<YundongtuijianView> selectListView(@Param("ew") Wrapper<YundongtuijianEntity> wrapper);

	List<YundongtuijianView> selectListView(Pagination page,@Param("ew") Wrapper<YundongtuijianEntity> wrapper);
	
	YundongtuijianView selectView(@Param("ew") Wrapper<YundongtuijianEntity> wrapper);
	

}
