package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShiwuleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShiwuleixingView;


/**
 * 食物类型
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface ShiwuleixingService extends IService<ShiwuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiwuleixingView> selectListView(Wrapper<ShiwuleixingEntity> wrapper);
   	
   	ShiwuleixingView selectView(@Param("ew") Wrapper<ShiwuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiwuleixingEntity> wrapper);
   	

}

