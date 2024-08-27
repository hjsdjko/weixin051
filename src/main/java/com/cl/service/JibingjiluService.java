package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JibingjiluEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JibingjiluView;


/**
 * 疾病记录
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
public interface JibingjiluService extends IService<JibingjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JibingjiluView> selectListView(Wrapper<JibingjiluEntity> wrapper);
   	
   	JibingjiluView selectView(@Param("ew") Wrapper<JibingjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JibingjiluEntity> wrapper);
   	

}

