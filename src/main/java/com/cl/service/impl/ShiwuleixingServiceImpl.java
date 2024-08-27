package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShiwuleixingDao;
import com.cl.entity.ShiwuleixingEntity;
import com.cl.service.ShiwuleixingService;
import com.cl.entity.view.ShiwuleixingView;

@Service("shiwuleixingService")
public class ShiwuleixingServiceImpl extends ServiceImpl<ShiwuleixingDao, ShiwuleixingEntity> implements ShiwuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiwuleixingEntity> page = this.selectPage(
                new Query<ShiwuleixingEntity>(params).getPage(),
                new EntityWrapper<ShiwuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiwuleixingEntity> wrapper) {
		  Page<ShiwuleixingView> page =new Query<ShiwuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShiwuleixingView> selectListView(Wrapper<ShiwuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiwuleixingView selectView(Wrapper<ShiwuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
