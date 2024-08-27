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


import com.cl.dao.YundongjiluDao;
import com.cl.entity.YundongjiluEntity;
import com.cl.service.YundongjiluService;
import com.cl.entity.view.YundongjiluView;

@Service("yundongjiluService")
public class YundongjiluServiceImpl extends ServiceImpl<YundongjiluDao, YundongjiluEntity> implements YundongjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YundongjiluEntity> page = this.selectPage(
                new Query<YundongjiluEntity>(params).getPage(),
                new EntityWrapper<YundongjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YundongjiluEntity> wrapper) {
		  Page<YundongjiluView> page =new Query<YundongjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YundongjiluView> selectListView(Wrapper<YundongjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YundongjiluView selectView(Wrapper<YundongjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
