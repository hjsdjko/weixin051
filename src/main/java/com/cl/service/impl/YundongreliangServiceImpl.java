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


import com.cl.dao.YundongreliangDao;
import com.cl.entity.YundongreliangEntity;
import com.cl.service.YundongreliangService;
import com.cl.entity.view.YundongreliangView;

@Service("yundongreliangService")
public class YundongreliangServiceImpl extends ServiceImpl<YundongreliangDao, YundongreliangEntity> implements YundongreliangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YundongreliangEntity> page = this.selectPage(
                new Query<YundongreliangEntity>(params).getPage(),
                new EntityWrapper<YundongreliangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YundongreliangEntity> wrapper) {
		  Page<YundongreliangView> page =new Query<YundongreliangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YundongreliangView> selectListView(Wrapper<YundongreliangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YundongreliangView selectView(Wrapper<YundongreliangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
