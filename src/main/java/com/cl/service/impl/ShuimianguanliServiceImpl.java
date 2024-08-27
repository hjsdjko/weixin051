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


import com.cl.dao.ShuimianguanliDao;
import com.cl.entity.ShuimianguanliEntity;
import com.cl.service.ShuimianguanliService;
import com.cl.entity.view.ShuimianguanliView;

@Service("shuimianguanliService")
public class ShuimianguanliServiceImpl extends ServiceImpl<ShuimianguanliDao, ShuimianguanliEntity> implements ShuimianguanliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShuimianguanliEntity> page = this.selectPage(
                new Query<ShuimianguanliEntity>(params).getPage(),
                new EntityWrapper<ShuimianguanliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShuimianguanliEntity> wrapper) {
		  Page<ShuimianguanliView> page =new Query<ShuimianguanliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShuimianguanliView> selectListView(Wrapper<ShuimianguanliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShuimianguanliView selectView(Wrapper<ShuimianguanliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ShuimianguanliEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ShuimianguanliEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ShuimianguanliEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
