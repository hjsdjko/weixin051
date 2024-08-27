package com.cl.dao;

import com.cl.entity.FenxibaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FenxibaogaoView;


/**
 * 分析报告
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:25
 */
public interface FenxibaogaoDao extends BaseMapper<FenxibaogaoEntity> {
	
	List<FenxibaogaoView> selectListView(@Param("ew") Wrapper<FenxibaogaoEntity> wrapper);

	List<FenxibaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<FenxibaogaoEntity> wrapper);
	
	FenxibaogaoView selectView(@Param("ew") Wrapper<FenxibaogaoEntity> wrapper);
	

}
