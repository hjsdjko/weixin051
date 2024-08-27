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


import com.cl.dao.YundongtuijianDao;
import com.cl.entity.YundongtuijianEntity;
import com.cl.service.YundongtuijianService;
import com.cl.entity.view.YundongtuijianView;

@Service("yundongtuijianService")
public class YundongtuijianServiceImpl extends ServiceImpl<YundongtuijianDao, YundongtuijianEntity> implements YundongtuijianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YundongtuijianEntity> page = this.selectPage(
                new Query<YundongtuijianEntity>(params).getPage(),
                new EntityWrapper<YundongtuijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YundongtuijianEntity> wrapper) {
		  Page<YundongtuijianView> page =new Query<YundongtuijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YundongtuijianView> selectListView(Wrapper<YundongtuijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YundongtuijianView selectView(Wrapper<YundongtuijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
