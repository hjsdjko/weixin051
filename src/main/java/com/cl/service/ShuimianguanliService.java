package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShuimianguanliEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShuimianguanliView;


/**
 * 睡眠管理
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface ShuimianguanliService extends IService<ShuimianguanliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShuimianguanliView> selectListView(Wrapper<ShuimianguanliEntity> wrapper);
   	
   	ShuimianguanliView selectView(@Param("ew") Wrapper<ShuimianguanliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShuimianguanliEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShuimianguanliEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShuimianguanliEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShuimianguanliEntity> wrapper);



}

