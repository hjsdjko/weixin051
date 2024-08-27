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


import com.cl.dao.FenxibaogaoDao;
import com.cl.entity.FenxibaogaoEntity;
import com.cl.service.FenxibaogaoService;
import com.cl.entity.view.FenxibaogaoView;

@Service("fenxibaogaoService")
public class FenxibaogaoServiceImpl extends ServiceImpl<FenxibaogaoDao, FenxibaogaoEntity> implements FenxibaogaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FenxibaogaoEntity> page = this.selectPage(
                new Query<FenxibaogaoEntity>(params).getPage(),
                new EntityWrapper<FenxibaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FenxibaogaoEntity> wrapper) {
		  Page<FenxibaogaoView> page =new Query<FenxibaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FenxibaogaoView> selectListView(Wrapper<FenxibaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FenxibaogaoView selectView(Wrapper<FenxibaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
