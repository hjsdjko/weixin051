package com.cl.dao;

import com.cl.entity.JibingjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JibingjiluView;


/**
 * 疾病记录
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface JibingjiluDao extends BaseMapper<JibingjiluEntity> {
	
	List<JibingjiluView> selectListView(@Param("ew") Wrapper<JibingjiluEntity> wrapper);

	List<JibingjiluView> selectListView(Pagination page,@Param("ew") Wrapper<JibingjiluEntity> wrapper);
	
	JibingjiluView selectView(@Param("ew") Wrapper<JibingjiluEntity> wrapper);
	

}
