package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YundongleixingEntity;
import com.cl.entity.view.YundongleixingView;

import com.cl.service.YundongleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 运动类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-14 15:30:25
 */
@RestController
@RequestMapping("/yundongleixing")
public class YundongleixingController {
    @Autowired
    private YundongleixingService yundongleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YundongleixingEntity yundongleixing,
		HttpServletRequest request){
        EntityWrapper<YundongleixingEntity> ew = new EntityWrapper<YundongleixingEntity>();

		PageUtils page = yundongleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YundongleixingEntity yundongleixing, 
		HttpServletRequest request){
        EntityWrapper<YundongleixingEntity> ew = new EntityWrapper<YundongleixingEntity>();

		PageUtils page = yundongleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YundongleixingEntity yundongleixing){
       	EntityWrapper<YundongleixingEntity> ew = new EntityWrapper<YundongleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yundongleixing, "yundongleixing")); 
        return R.ok().put("data", yundongleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YundongleixingEntity yundongleixing){
        EntityWrapper< YundongleixingEntity> ew = new EntityWrapper< YundongleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yundongleixing, "yundongleixing")); 
		YundongleixingView yundongleixingView =  yundongleixingService.selectView(ew);
		return R.ok("查询运动类型成功").put("data", yundongleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YundongleixingEntity yundongleixing = yundongleixingService.selectById(id);
		yundongleixing = yundongleixingService.selectView(new EntityWrapper<YundongleixingEntity>().eq("id", id));
        return R.ok().put("data", yundongleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YundongleixingEntity yundongleixing = yundongleixingService.selectById(id);
		yundongleixing = yundongleixingService.selectView(new EntityWrapper<YundongleixingEntity>().eq("id", id));
        return R.ok().put("data", yundongleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YundongleixingEntity yundongleixing, HttpServletRequest request){
    	yundongleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yundongleixing);
        yundongleixingService.insert(yundongleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YundongleixingEntity yundongleixing, HttpServletRequest request){
    	yundongleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yundongleixing);
        yundongleixingService.insert(yundongleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YundongleixingEntity yundongleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yundongleixing);
        yundongleixingService.updateById(yundongleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yundongleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}