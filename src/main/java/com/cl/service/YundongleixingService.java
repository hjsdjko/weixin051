package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YundongleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YundongleixingView;


/**
 * 运动类型
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:25
 */
public interface YundongleixingService extends IService<YundongleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YundongleixingView> selectListView(Wrapper<YundongleixingEntity> wrapper);
   	
   	YundongleixingView selectView(@Param("ew") Wrapper<YundongleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YundongleixingEntity> wrapper);
   	

}

