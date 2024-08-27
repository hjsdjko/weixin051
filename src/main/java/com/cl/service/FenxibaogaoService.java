package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FenxibaogaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FenxibaogaoView;


/**
 * 分析报告
 *
 * @author 
 * @email 
 * @date 2024-03-14 15:30:25
 */
public interface FenxibaogaoService extends IService<FenxibaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FenxibaogaoView> selectListView(Wrapper<FenxibaogaoEntity> wrapper);
   	
   	FenxibaogaoView selectView(@Param("ew") Wrapper<FenxibaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FenxibaogaoEntity> wrapper);
   	

}

