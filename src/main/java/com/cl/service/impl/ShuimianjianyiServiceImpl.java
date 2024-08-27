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


import com.cl.dao.ShuimianjianyiDao;
import com.cl.entity.ShuimianjianyiEntity;
import com.cl.service.ShuimianjianyiService;
import com.cl.entity.view.ShuimianjianyiView;

@Service("shuimianjianyiService")
public class ShuimianjianyiServiceImpl extends ServiceImpl<ShuimianjianyiDao, ShuimianjianyiEntity> implements ShuimianjianyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShuimianjianyiEntity> page = this.selectPage(
                new Query<ShuimianjianyiEntity>(params).getPage(),
                new EntityWrapper<ShuimianjianyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShuimianjianyiEntity> wrapper) {
		  Page<ShuimianjianyiView> page =new Query<ShuimianjianyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShuimianjianyiView> selectListView(Wrapper<ShuimianjianyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShuimianjianyiView selectView(Wrapper<ShuimianjianyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
