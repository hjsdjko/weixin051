package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShuimianjianyiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShuimianjianyiView;


/**
 * 睡眠建议
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface ShuimianjianyiService extends IService<ShuimianjianyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShuimianjianyiView> selectListView(Wrapper<ShuimianjianyiEntity> wrapper);
   	
   	ShuimianjianyiView selectView(@Param("ew") Wrapper<ShuimianjianyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShuimianjianyiEntity> wrapper);
   	

}

