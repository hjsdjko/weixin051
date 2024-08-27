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

import com.cl.entity.YundongreliangEntity;
import com.cl.entity.view.YundongreliangView;

import com.cl.service.YundongreliangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 运动热量
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
@RestController
@RequestMapping("/yundongreliang")
public class YundongreliangController {
    @Autowired
    private YundongreliangService yundongreliangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YundongreliangEntity yundongreliang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yundongreliang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YundongreliangEntity> ew = new EntityWrapper<YundongreliangEntity>();

		PageUtils page = yundongreliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongreliang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YundongreliangEntity yundongreliang, 
		HttpServletRequest request){
        EntityWrapper<YundongreliangEntity> ew = new EntityWrapper<YundongreliangEntity>();

		PageUtils page = yundongreliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongreliang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YundongreliangEntity yundongreliang){
       	EntityWrapper<YundongreliangEntity> ew = new EntityWrapper<YundongreliangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yundongreliang, "yundongreliang")); 
        return R.ok().put("data", yundongreliangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YundongreliangEntity yundongreliang){
        EntityWrapper< YundongreliangEntity> ew = new EntityWrapper< YundongreliangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yundongreliang, "yundongreliang")); 
		YundongreliangView yundongreliangView =  yundongreliangService.selectView(ew);
		return R.ok("查询运动热量成功").put("data", yundongreliangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YundongreliangEntity yundongreliang = yundongreliangService.selectById(id);
		yundongreliang = yundongreliangService.selectView(new EntityWrapper<YundongreliangEntity>().eq("id", id));
        return R.ok().put("data", yundongreliang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YundongreliangEntity yundongreliang = yundongreliangService.selectById(id);
		yundongreliang = yundongreliangService.selectView(new EntityWrapper<YundongreliangEntity>().eq("id", id));
        return R.ok().put("data", yundongreliang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YundongreliangEntity yundongreliang, HttpServletRequest request){
    	yundongreliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yundongreliang);
        yundongreliangService.insert(yundongreliang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YundongreliangEntity yundongreliang, HttpServletRequest request){
    	yundongreliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yundongreliang);
        yundongreliangService.insert(yundongreliang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YundongreliangEntity yundongreliang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yundongreliang);
        yundongreliangService.updateById(yundongreliang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yundongreliangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
