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

import com.cl.entity.YinshireliangEntity;
import com.cl.entity.view.YinshireliangView;

import com.cl.service.YinshireliangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 饮食热量
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
@RestController
@RequestMapping("/yinshireliang")
public class YinshireliangController {
    @Autowired
    private YinshireliangService yinshireliangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinshireliangEntity yinshireliang,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yinshireliang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YinshireliangEntity> ew = new EntityWrapper<YinshireliangEntity>();
                if(jiluriqistart!=null) ew.ge("jiluriqi", jiluriqistart);
                if(jiluriqiend!=null) ew.le("jiluriqi", jiluriqiend);

		PageUtils page = yinshireliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshireliang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinshireliangEntity yinshireliang, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiluriqiend,
		HttpServletRequest request){
        EntityWrapper<YinshireliangEntity> ew = new EntityWrapper<YinshireliangEntity>();
                if(jiluriqistart!=null) ew.ge("jiluriqi", jiluriqistart);
                if(jiluriqiend!=null) ew.le("jiluriqi", jiluriqiend);

		PageUtils page = yinshireliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshireliang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinshireliangEntity yinshireliang){
       	EntityWrapper<YinshireliangEntity> ew = new EntityWrapper<YinshireliangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinshireliang, "yinshireliang")); 
        return R.ok().put("data", yinshireliangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinshireliangEntity yinshireliang){
        EntityWrapper< YinshireliangEntity> ew = new EntityWrapper< YinshireliangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinshireliang, "yinshireliang")); 
		YinshireliangView yinshireliangView =  yinshireliangService.selectView(ew);
		return R.ok("查询饮食热量成功").put("data", yinshireliangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinshireliangEntity yinshireliang = yinshireliangService.selectById(id);
		yinshireliang = yinshireliangService.selectView(new EntityWrapper<YinshireliangEntity>().eq("id", id));
        return R.ok().put("data", yinshireliang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinshireliangEntity yinshireliang = yinshireliangService.selectById(id);
		yinshireliang = yinshireliangService.selectView(new EntityWrapper<YinshireliangEntity>().eq("id", id));
        return R.ok().put("data", yinshireliang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinshireliangEntity yinshireliang, HttpServletRequest request){
    	yinshireliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinshireliang);
        yinshireliangService.insert(yinshireliang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinshireliangEntity yinshireliang, HttpServletRequest request){
    	yinshireliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinshireliang);
        yinshireliangService.insert(yinshireliang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinshireliangEntity yinshireliang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshireliang);
        yinshireliangService.updateById(yinshireliang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinshireliangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
