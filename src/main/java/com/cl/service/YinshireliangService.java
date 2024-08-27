package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinshireliangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinshireliangView;


/**
 * 饮食热量
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface YinshireliangService extends IService<YinshireliangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinshireliangView> selectListView(Wrapper<YinshireliangEntity> wrapper);
   	
   	YinshireliangView selectView(@Param("ew") Wrapper<YinshireliangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinshireliangEntity> wrapper);
   	

}

