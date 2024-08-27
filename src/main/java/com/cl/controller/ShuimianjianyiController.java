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

import com.cl.entity.ShuimianjianyiEntity;
import com.cl.entity.view.ShuimianjianyiView;

import com.cl.service.ShuimianjianyiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 睡眠建议
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
@RestController
@RequestMapping("/shuimianjianyi")
public class ShuimianjianyiController {
    @Autowired
    private ShuimianjianyiService shuimianjianyiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShuimianjianyiEntity shuimianjianyi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shuimianjianyi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShuimianjianyiEntity> ew = new EntityWrapper<ShuimianjianyiEntity>();

		PageUtils page = shuimianjianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shuimianjianyi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShuimianjianyiEntity shuimianjianyi, 
		HttpServletRequest request){
        EntityWrapper<ShuimianjianyiEntity> ew = new EntityWrapper<ShuimianjianyiEntity>();

		PageUtils page = shuimianjianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shuimianjianyi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShuimianjianyiEntity shuimianjianyi){
       	EntityWrapper<ShuimianjianyiEntity> ew = new EntityWrapper<ShuimianjianyiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shuimianjianyi, "shuimianjianyi")); 
        return R.ok().put("data", shuimianjianyiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShuimianjianyiEntity shuimianjianyi){
        EntityWrapper< ShuimianjianyiEntity> ew = new EntityWrapper< ShuimianjianyiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shuimianjianyi, "shuimianjianyi")); 
		ShuimianjianyiView shuimianjianyiView =  shuimianjianyiService.selectView(ew);
		return R.ok("查询睡眠建议成功").put("data", shuimianjianyiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShuimianjianyiEntity shuimianjianyi = shuimianjianyiService.selectById(id);
		shuimianjianyi = shuimianjianyiService.selectView(new EntityWrapper<ShuimianjianyiEntity>().eq("id", id));
        return R.ok().put("data", shuimianjianyi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShuimianjianyiEntity shuimianjianyi = shuimianjianyiService.selectById(id);
		shuimianjianyi = shuimianjianyiService.selectView(new EntityWrapper<ShuimianjianyiEntity>().eq("id", id));
        return R.ok().put("data", shuimianjianyi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShuimianjianyiEntity shuimianjianyi, HttpServletRequest request){
    	shuimianjianyi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shuimianjianyi);
        shuimianjianyiService.insert(shuimianjianyi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShuimianjianyiEntity shuimianjianyi, HttpServletRequest request){
    	shuimianjianyi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shuimianjianyi);
        shuimianjianyiService.insert(shuimianjianyi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShuimianjianyiEntity shuimianjianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shuimianjianyi);
        shuimianjianyiService.updateById(shuimianjianyi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shuimianjianyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
