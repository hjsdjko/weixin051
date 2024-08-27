package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YundongjiluEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YundongjiluView;


/**
 * 运动记录
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:23
 */
public interface YundongjiluService extends IService<YundongjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YundongjiluView> selectListView(Wrapper<YundongjiluEntity> wrapper);
   	
   	YundongjiluView selectView(@Param("ew") Wrapper<YundongjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YundongjiluEntity> wrapper);
   	

}

