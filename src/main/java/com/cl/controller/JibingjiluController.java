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

import com.cl.entity.JibingjiluEntity;
import com.cl.entity.view.JibingjiluView;

import com.cl.service.JibingjiluService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 疾病记录
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
@RestController
@RequestMapping("/jibingjilu")
public class JibingjiluController {
    @Autowired
    private JibingjiluService jibingjiluService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JibingjiluEntity jibingjilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jibingjilu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JibingjiluEntity> ew = new EntityWrapper<JibingjiluEntity>();

		PageUtils page = jibingjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jibingjilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JibingjiluEntity jibingjilu, 
		HttpServletRequest request){
        EntityWrapper<JibingjiluEntity> ew = new EntityWrapper<JibingjiluEntity>();

		PageUtils page = jibingjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jibingjilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JibingjiluEntity jibingjilu){
       	EntityWrapper<JibingjiluEntity> ew = new EntityWrapper<JibingjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jibingjilu, "jibingjilu")); 
        return R.ok().put("data", jibingjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JibingjiluEntity jibingjilu){
        EntityWrapper< JibingjiluEntity> ew = new EntityWrapper< JibingjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jibingjilu, "jibingjilu")); 
		JibingjiluView jibingjiluView =  jibingjiluService.selectView(ew);
		return R.ok("查询疾病记录成功").put("data", jibingjiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JibingjiluEntity jibingjilu = jibingjiluService.selectById(id);
		jibingjilu = jibingjiluService.selectView(new EntityWrapper<JibingjiluEntity>().eq("id", id));
        return R.ok().put("data", jibingjilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JibingjiluEntity jibingjilu = jibingjiluService.selectById(id);
		jibingjilu = jibingjiluService.selectView(new EntityWrapper<JibingjiluEntity>().eq("id", id));
        return R.ok().put("data", jibingjilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JibingjiluEntity jibingjilu, HttpServletRequest request){
    	jibingjilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jibingjilu);
        jibingjiluService.insert(jibingjilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JibingjiluEntity jibingjilu, HttpServletRequest request){
    	jibingjilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jibingjilu);
        jibingjiluService.insert(jibingjilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JibingjiluEntity jibingjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingjilu);
        jibingjiluService.updateById(jibingjilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jibingjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
