package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YundongreliangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YundongreliangView;


/**
 * 运动热量
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface YundongreliangService extends IService<YundongreliangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YundongreliangView> selectListView(Wrapper<YundongreliangEntity> wrapper);
   	
   	YundongreliangView selectView(@Param("ew") Wrapper<YundongreliangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YundongreliangEntity> wrapper);
   	

}

