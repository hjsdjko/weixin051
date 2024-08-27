package com.cl.dao;

import com.cl.entity.ShiwuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiwuleixingView;


/**
 * 食物类型
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface ShiwuleixingDao extends BaseMapper<ShiwuleixingEntity> {
	
	List<ShiwuleixingView> selectListView(@Param("ew") Wrapper<ShiwuleixingEntity> wrapper);

	List<ShiwuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ShiwuleixingEntity> wrapper);
	
	ShiwuleixingView selectView(@Param("ew") Wrapper<ShiwuleixingEntity> wrapper);
	

}
