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

import com.cl.entity.FenxibaogaoEntity;
import com.cl.entity.view.FenxibaogaoView;

import com.cl.service.FenxibaogaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 分析报告
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-14 15:30:25
 */
@RestController
@RequestMapping("/fenxibaogao")
public class FenxibaogaoController {
    @Autowired
    private FenxibaogaoService fenxibaogaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FenxibaogaoEntity fenxibaogao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			fenxibaogao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FenxibaogaoEntity> ew = new EntityWrapper<FenxibaogaoEntity>();

		PageUtils page = fenxibaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fenxibaogao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FenxibaogaoEntity fenxibaogao, 
		HttpServletRequest request){
        EntityWrapper<FenxibaogaoEntity> ew = new EntityWrapper<FenxibaogaoEntity>();

		PageUtils page = fenxibaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fenxibaogao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FenxibaogaoEntity fenxibaogao){
       	EntityWrapper<FenxibaogaoEntity> ew = new EntityWrapper<FenxibaogaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fenxibaogao, "fenxibaogao")); 
        return R.ok().put("data", fenxibaogaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FenxibaogaoEntity fenxibaogao){
        EntityWrapper< FenxibaogaoEntity> ew = new EntityWrapper< FenxibaogaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fenxibaogao, "fenxibaogao")); 
		FenxibaogaoView fenxibaogaoView =  fenxibaogaoService.selectView(ew);
		return R.ok("查询分析报告成功").put("data", fenxibaogaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FenxibaogaoEntity fenxibaogao = fenxibaogaoService.selectById(id);
		fenxibaogao = fenxibaogaoService.selectView(new EntityWrapper<FenxibaogaoEntity>().eq("id", id));
        return R.ok().put("data", fenxibaogao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FenxibaogaoEntity fenxibaogao = fenxibaogaoService.selectById(id);
		fenxibaogao = fenxibaogaoService.selectView(new EntityWrapper<FenxibaogaoEntity>().eq("id", id));
        return R.ok().put("data", fenxibaogao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FenxibaogaoEntity fenxibaogao, HttpServletRequest request){
    	fenxibaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fenxibaogao);
        fenxibaogaoService.insert(fenxibaogao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FenxibaogaoEntity fenxibaogao, HttpServletRequest request){
    	fenxibaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fenxibaogao);
        fenxibaogaoService.insert(fenxibaogao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FenxibaogaoEntity fenxibaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fenxibaogao);
        fenxibaogaoService.updateById(fenxibaogao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fenxibaogaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
