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

import com.cl.entity.YinshituijianEntity;
import com.cl.entity.view.YinshituijianView;

import com.cl.service.YinshituijianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 饮食推荐
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
@RestController
@RequestMapping("/yinshituijian")
public class YinshituijianController {
    @Autowired
    private YinshituijianService yinshituijianService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinshituijianEntity yinshituijian,
		HttpServletRequest request){
        EntityWrapper<YinshituijianEntity> ew = new EntityWrapper<YinshituijianEntity>();

		PageUtils page = yinshituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshituijian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinshituijianEntity yinshituijian, 
		HttpServletRequest request){
        EntityWrapper<YinshituijianEntity> ew = new EntityWrapper<YinshituijianEntity>();

		PageUtils page = yinshituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshituijian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinshituijianEntity yinshituijian){
       	EntityWrapper<YinshituijianEntity> ew = new EntityWrapper<YinshituijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinshituijian, "yinshituijian")); 
        return R.ok().put("data", yinshituijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinshituijianEntity yinshituijian){
        EntityWrapper< YinshituijianEntity> ew = new EntityWrapper< YinshituijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinshituijian, "yinshituijian")); 
		YinshituijianView yinshituijianView =  yinshituijianService.selectView(ew);
		return R.ok("查询饮食推荐成功").put("data", yinshituijianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinshituijianEntity yinshituijian = yinshituijianService.selectById(id);
		yinshituijian.setClicknum(yinshituijian.getClicknum()+1);
		yinshituijian.setClicktime(new Date());
		yinshituijianService.updateById(yinshituijian);
		yinshituijian = yinshituijianService.selectView(new EntityWrapper<YinshituijianEntity>().eq("id", id));
        return R.ok().put("data", yinshituijian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinshituijianEntity yinshituijian = yinshituijianService.selectById(id);
		yinshituijian.setClicknum(yinshituijian.getClicknum()+1);
		yinshituijian.setClicktime(new Date());
		yinshituijianService.updateById(yinshituijian);
		yinshituijian = yinshituijianService.selectView(new EntityWrapper<YinshituijianEntity>().eq("id", id));
        return R.ok().put("data", yinshituijian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinshituijianEntity yinshituijian, HttpServletRequest request){
    	yinshituijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinshituijian);
        yinshituijianService.insert(yinshituijian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinshituijianEntity yinshituijian, HttpServletRequest request){
    	yinshituijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinshituijian);
        yinshituijianService.insert(yinshituijian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinshituijianEntity yinshituijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshituijian);
        yinshituijianService.updateById(yinshituijian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinshituijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YinshituijianEntity yinshituijian, HttpServletRequest request,String pre){
        EntityWrapper<YinshituijianEntity> ew = new EntityWrapper<YinshituijianEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = yinshituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshituijian), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YinshituijianEntity yinshituijian, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "shiwuleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "yinshituijian").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<YinshituijianEntity> yinshituijianList = new ArrayList<YinshituijianEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                yinshituijianList.addAll(yinshituijianService.selectList(new EntityWrapper<YinshituijianEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<YinshituijianEntity> ew = new EntityWrapper<YinshituijianEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = yinshituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshituijian), params), params));
        List<YinshituijianEntity> pageList = (List<YinshituijianEntity>)page.getList();
        if(yinshituijianList.size()<limit) {
            int toAddNum = (limit-yinshituijianList.size())<=pageList.size()?(limit-yinshituijianList.size()):pageList.size();
            for(YinshituijianEntity o1 : pageList) {
                boolean addFlag = true;
                for(YinshituijianEntity o2 : yinshituijianList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    yinshituijianList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(yinshituijianList.size()>limit) {
            yinshituijianList = yinshituijianList.subList(0, limit);
        }
        page.setList(yinshituijianList);
        return R.ok().put("data", page);
    }







}
