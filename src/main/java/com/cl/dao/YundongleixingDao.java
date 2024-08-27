package com.cl.dao;

import com.cl.entity.YundongleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YundongleixingView;


/**
 * 运动类型
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:25
 */
public interface YundongleixingDao extends BaseMapper<YundongleixingEntity> {
	
	List<YundongleixingView> selectListView(@Param("ew") Wrapper<YundongleixingEntity> wrapper);

	List<YundongleixingView> selectListView(Pagination page,@Param("ew") Wrapper<YundongleixingEntity> wrapper);
	
	YundongleixingView selectView(@Param("ew") Wrapper<YundongleixingEntity> wrapper);
	

}
