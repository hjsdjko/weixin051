package com.cl.entity.view;

import com.cl.entity.ShiwuleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 食物类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
@TableName("shiwuleixing")
public class ShiwuleixingView  extends ShiwuleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShiwuleixingView(){
	}
 
 	public ShiwuleixingView(ShiwuleixingEntity shiwuleixingEntity){
 	try {
			BeanUtils.copyProperties(this, shiwuleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
