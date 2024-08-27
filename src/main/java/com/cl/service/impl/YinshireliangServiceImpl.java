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


import com.cl.dao.YinshireliangDao;
import com.cl.entity.YinshireliangEntity;
import com.cl.service.YinshireliangService;
import com.cl.entity.view.YinshireliangView;

@Service("yinshireliangService")
public class YinshireliangServiceImpl extends ServiceImpl<YinshireliangDao, YinshireliangEntity> implements YinshireliangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinshireliangEntity> page = this.selectPage(
                new Query<YinshireliangEntity>(params).getPage(),
                new EntityWrapper<YinshireliangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinshireliangEntity> wrapper) {
		  Page<YinshireliangView> page =new Query<YinshireliangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YinshireliangView> selectListView(Wrapper<YinshireliangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinshireliangView selectView(Wrapper<YinshireliangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
