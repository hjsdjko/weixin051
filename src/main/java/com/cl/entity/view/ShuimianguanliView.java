package com.cl.entity.view;

import com.cl.entity.ShuimianguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 睡眠管理
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
@TableName("shuimianguanli")
public class ShuimianguanliView  extends ShuimianguanliEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShuimianguanliView(){
	}
 
 	public ShuimianguanliView(ShuimianguanliEntity shuimianguanliEntity){
 	try {
			BeanUtils.copyProperties(this, shuimianguanliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
