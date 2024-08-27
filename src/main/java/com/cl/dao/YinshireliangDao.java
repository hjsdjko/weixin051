package com.cl.dao;

import com.cl.entity.YinshireliangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinshireliangView;


/**
 * 饮食热量
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface YinshireliangDao extends BaseMapper<YinshireliangEntity> {
	
	List<YinshireliangView> selectListView(@Param("ew") Wrapper<YinshireliangEntity> wrapper);

	List<YinshireliangView> selectListView(Pagination page,@Param("ew") Wrapper<YinshireliangEntity> wrapper);
	
	YinshireliangView selectView(@Param("ew") Wrapper<YinshireliangEntity> wrapper);
	

}
