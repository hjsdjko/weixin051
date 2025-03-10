package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 运动热量
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
@TableName("yundongreliang")
public class YundongreliangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YundongreliangEntity() {
		
	}
	
	public YundongreliangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 运动名称
	 */
					
	private String yundongmingcheng;
	
	/**
	 * 运动时长
	 */
					
	private Integer yundongshizhang;
	
	/**
	 * 消耗热量
	 */
					
	private String xiaohaoreliang;
	
	/**
	 * 运动建议
	 */
					
	private String yundongjianyi;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：运动名称
	 */
	public void setYundongmingcheng(String yundongmingcheng) {
		this.yundongmingcheng = yundongmingcheng;
	}
	/**
	 * 获取：运动名称
	 */
	public String getYundongmingcheng() {
		return yundongmingcheng;
	}
	/**
	 * 设置：运动时长
	 */
	public void setYundongshizhang(Integer yundongshizhang) {
		this.yundongshizhang = yundongshizhang;
	}
	/**
	 * 获取：运动时长
	 */
	public Integer getYundongshizhang() {
		return yundongshizhang;
	}
	/**
	 * 设置：消耗热量
	 */
	public void setXiaohaoreliang(String xiaohaoreliang) {
		this.xiaohaoreliang = xiaohaoreliang;
	}
	/**
	 * 获取：消耗热量
	 */
	public String getXiaohaoreliang() {
		return xiaohaoreliang;
	}
	/**
	 * 设置：运动建议
	 */
	public void setYundongjianyi(String yundongjianyi) {
		this.yundongjianyi = yundongjianyi;
	}
	/**
	 * 获取：运动建议
	 */
	public String getYundongjianyi() {
		return yundongjianyi;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}

}
