package com.cl.dao;

import com.cl.entity.ShuimianguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShuimianguanliView;


/**
 * 睡眠管理
 * 
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface ShuimianguanliDao extends BaseMapper<ShuimianguanliEntity> {
	
	List<ShuimianguanliView> selectListView(@Param("ew") Wrapper<ShuimianguanliEntity> wrapper);

	List<ShuimianguanliView> selectListView(Pagination page,@Param("ew") Wrapper<ShuimianguanliEntity> wrapper);
	
	ShuimianguanliView selectView(@Param("ew") Wrapper<ShuimianguanliEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShuimianguanliEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShuimianguanliEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShuimianguanliEntity> wrapper);



}
