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

import com.cl.entity.YundongtuijianEntity;
import com.cl.entity.view.YundongtuijianView;

import com.cl.service.YundongtuijianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 运动推荐
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-14 15:30:25
 */
@RestController
@RequestMapping("/yundongtuijian")
public class YundongtuijianController {
    @Autowired
    private YundongtuijianService yundongtuijianService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YundongtuijianEntity yundongtuijian,
		HttpServletRequest request){
        EntityWrapper<YundongtuijianEntity> ew = new EntityWrapper<YundongtuijianEntity>();

		PageUtils page = yundongtuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongtuijian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YundongtuijianEntity yundongtuijian, 
		HttpServletRequest request){
        EntityWrapper<YundongtuijianEntity> ew = new EntityWrapper<YundongtuijianEntity>();

		PageUtils page = yundongtuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongtuijian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YundongtuijianEntity yundongtuijian){
       	EntityWrapper<YundongtuijianEntity> ew = new EntityWrapper<YundongtuijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yundongtuijian, "yundongtuijian")); 
        return R.ok().put("data", yundongtuijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YundongtuijianEntity yundongtuijian){
        EntityWrapper< YundongtuijianEntity> ew = new EntityWrapper< YundongtuijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yundongtuijian, "yundongtuijian")); 
		YundongtuijianView yundongtuijianView =  yundongtuijianService.selectView(ew);
		return R.ok("查询运动推荐成功").put("data", yundongtuijianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YundongtuijianEntity yundongtuijian = yundongtuijianService.selectById(id);
		yundongtuijian.setClicknum(yundongtuijian.getClicknum()+1);
		yundongtuijian.setClicktime(new Date());
		yundongtuijianService.updateById(yundongtuijian);
		yundongtuijian = yundongtuijianService.selectView(new EntityWrapper<YundongtuijianEntity>().eq("id", id));
        return R.ok().put("data", yundongtuijian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YundongtuijianEntity yundongtuijian = yundongtuijianService.selectById(id);
		yundongtuijian.setClicknum(yundongtuijian.getClicknum()+1);
		yundongtuijian.setClicktime(new Date());
		yundongtuijianService.updateById(yundongtuijian);
		yundongtuijian = yundongtuijianService.selectView(new EntityWrapper<YundongtuijianEntity>().eq("id", id));
        return R.ok().put("data", yundongtuijian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YundongtuijianEntity yundongtuijian, HttpServletRequest request){
    	yundongtuijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yundongtuijian);
        yundongtuijianService.insert(yundongtuijian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YundongtuijianEntity yundongtuijian, HttpServletRequest request){
    	yundongtuijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yundongtuijian);
        yundongtuijianService.insert(yundongtuijian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YundongtuijianEntity yundongtuijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yundongtuijian);
        yundongtuijianService.updateById(yundongtuijian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yundongtuijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YundongtuijianEntity yundongtuijian, HttpServletRequest request,String pre){
        EntityWrapper<YundongtuijianEntity> ew = new EntityWrapper<YundongtuijianEntity>();
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
		PageUtils page = yundongtuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongtuijian), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YundongtuijianEntity yundongtuijian, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "yundongleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "yundongtuijian").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<YundongtuijianEntity> yundongtuijianList = new ArrayList<YundongtuijianEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                yundongtuijianList.addAll(yundongtuijianService.selectList(new EntityWrapper<YundongtuijianEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<YundongtuijianEntity> ew = new EntityWrapper<YundongtuijianEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = yundongtuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yundongtuijian), params), params));
        List<YundongtuijianEntity> pageList = (List<YundongtuijianEntity>)page.getList();
        if(yundongtuijianList.size()<limit) {
            int toAddNum = (limit-yundongtuijianList.size())<=pageList.size()?(limit-yundongtuijianList.size()):pageList.size();
            for(YundongtuijianEntity o1 : pageList) {
                boolean addFlag = true;
                for(YundongtuijianEntity o2 : yundongtuijianList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    yundongtuijianList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(yundongtuijianList.size()>limit) {
            yundongtuijianList = yundongtuijianList.subList(0, limit);
        }
        page.setList(yundongtuijianList);
        return R.ok().put("data", page);
    }







}
