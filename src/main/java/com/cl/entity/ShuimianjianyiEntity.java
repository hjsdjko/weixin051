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
 * 睡眠建议
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-14 15:30:24
 */
@TableName("shuimianjianyi")
public class ShuimianjianyiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShuimianjianyiEntity() {
		
	}
	
	public ShuimianjianyiEntity(T t) {
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
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 睡眠时长
	 */
					
	private Integer shuimianshizhang;
	
	/**
	 * 睡眠建议
	 */
					
	private String shuimianjianyi;
	
	/**
	 * 睡眠质量
	 */
					
	private String shuimianzhiliang;
	
	/**
	 * 建议时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jianyishijian;
	
	
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
	/**
	 * 设置：睡眠时长
	 */
	public void setShuimianshizhang(Integer shuimianshizhang) {
		this.shuimianshizhang = shuimianshizhang;
	}
	/**
	 * 获取：睡眠时长
	 */
	public Integer getShuimianshizhang() {
		return shuimianshizhang;
	}
	/**
	 * 设置：睡眠建议
	 */
	public void setShuimianjianyi(String shuimianjianyi) {
		this.shuimianjianyi = shuimianjianyi;
	}
	/**
	 * 获取：睡眠建议
	 */
	public String getShuimianjianyi() {
		return shuimianjianyi;
	}
	/**
	 * 设置：睡眠质量
	 */
	public void setShuimianzhiliang(String shuimianzhiliang) {
		this.shuimianzhiliang = shuimianzhiliang;
	}
	/**
	 * 获取：睡眠质量
	 */
	public String getShuimianzhiliang() {
		return shuimianzhiliang;
	}
	/**
	 * 设置：建议时间
	 */
	public void setJianyishijian(Date jianyishijian) {
		this.jianyishijian = jianyishijian;
	}
	/**
	 * 获取：建议时间
	 */
	public Date getJianyishijian() {
		return jianyishijian;
	}

}
