package com.cl.dao;

import com.cl.entity.ShuimianjianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShuimianjianyiView;


/**
 * 睡眠建议
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface ShuimianjianyiDao extends BaseMapper<ShuimianjianyiEntity> {
	
	List<ShuimianjianyiView> selectListView(@Param("ew") Wrapper<ShuimianjianyiEntity> wrapper);

	List<ShuimianjianyiView> selectListView(Pagination page,@Param("ew") Wrapper<ShuimianjianyiEntity> wrapper);
	
	ShuimianjianyiView selectView(@Param("ew") Wrapper<ShuimianjianyiEntity> wrapper);
	

}
