package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YundongtuijianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YundongtuijianView;


/**
 * 运动推荐
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:25
 */
public interface YundongtuijianService extends IService<YundongtuijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YundongtuijianView> selectListView(Wrapper<YundongtuijianEntity> wrapper);
   	
   	YundongtuijianView selectView(@Param("ew") Wrapper<YundongtuijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YundongtuijianEntity> wrapper);
   	

}

