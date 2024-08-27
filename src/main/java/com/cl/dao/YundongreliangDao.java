package com.cl.dao;

import com.cl.entity.YundongreliangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YundongreliangView;


/**
 * 运动热量
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface YundongreliangDao extends BaseMapper<YundongreliangEntity> {
	
	List<YundongreliangView> selectListView(@Param("ew") Wrapper<YundongreliangEntity> wrapper);

	List<YundongreliangView> selectListView(Pagination page,@Param("ew") Wrapper<YundongreliangEntity> wrapper);
	
	YundongreliangView selectView(@Param("ew") Wrapper<YundongreliangEntity> wrapper);
	

}
