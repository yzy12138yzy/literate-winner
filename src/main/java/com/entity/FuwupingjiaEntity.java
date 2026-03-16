package com.entity;

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
 * 服务评价
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-06 08:48:06
 */
@TableName("fuwupingjia")
public class FuwupingjiaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FuwupingjiaEntity() {
		
	}
	
	public FuwupingjiaEntity(T t) {
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
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 订单编号
	 */
					
	private String dingdanbianhao;
	
	/**
	 * 服务名称
	 */
					
	private String fuwumingcheng;
	
	/**
	 * 服务类型
	 */
					
	private String fuwuleixing;
	
	/**
	 * 服务时长
	 */
					
	private String fuwushizhang;
	
	/**
	 * 服务图片
	 */
					
	private String fuwutupian;
	
	/**
	 * 服务效率
	 */
					
	private String fuwuxiaolv;
	
	/**
	 * 服务态度
	 */
					
	private String fuwutaidu;
	
	/**
	 * 服务质量
	 */
					
	private String fuwuzhiliang;
	
	/**
	 * 评价建议
	 */
					
	private String pingjiajianyi;
	
	/**
	 * 员工工号
	 */
					
	private String yuangonggonghao;
	
	/**
	 * 员工姓名
	 */
					
	private String yuangongxingming;
	
	/**
	 * 店铺名称
	 */
					
	private String dianpumingcheng;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
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
	 * 设置：订单编号
	 */
	public void setDingdanbianhao(String dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	/**
	 * 获取：订单编号
	 */
	public String getDingdanbianhao() {
		return dingdanbianhao;
	}
	/**
	 * 设置：服务名称
	 */
	public void setFuwumingcheng(String fuwumingcheng) {
		this.fuwumingcheng = fuwumingcheng;
	}
	/**
	 * 获取：服务名称
	 */
	public String getFuwumingcheng() {
		return fuwumingcheng;
	}
	/**
	 * 设置：服务类型
	 */
	public void setFuwuleixing(String fuwuleixing) {
		this.fuwuleixing = fuwuleixing;
	}
	/**
	 * 获取：服务类型
	 */
	public String getFuwuleixing() {
		return fuwuleixing;
	}
	/**
	 * 设置：服务时长
	 */
	public void setFuwushizhang(String fuwushizhang) {
		this.fuwushizhang = fuwushizhang;
	}
	/**
	 * 获取：服务时长
	 */
	public String getFuwushizhang() {
		return fuwushizhang;
	}
	/**
	 * 设置：服务图片
	 */
	public void setFuwutupian(String fuwutupian) {
		this.fuwutupian = fuwutupian;
	}
	/**
	 * 获取：服务图片
	 */
	public String getFuwutupian() {
		return fuwutupian;
	}
	/**
	 * 设置：服务效率
	 */
	public void setFuwuxiaolv(String fuwuxiaolv) {
		this.fuwuxiaolv = fuwuxiaolv;
	}
	/**
	 * 获取：服务效率
	 */
	public String getFuwuxiaolv() {
		return fuwuxiaolv;
	}
	/**
	 * 设置：服务态度
	 */
	public void setFuwutaidu(String fuwutaidu) {
		this.fuwutaidu = fuwutaidu;
	}
	/**
	 * 获取：服务态度
	 */
	public String getFuwutaidu() {
		return fuwutaidu;
	}
	/**
	 * 设置：服务质量
	 */
	public void setFuwuzhiliang(String fuwuzhiliang) {
		this.fuwuzhiliang = fuwuzhiliang;
	}
	/**
	 * 获取：服务质量
	 */
	public String getFuwuzhiliang() {
		return fuwuzhiliang;
	}
	/**
	 * 设置：评价建议
	 */
	public void setPingjiajianyi(String pingjiajianyi) {
		this.pingjiajianyi = pingjiajianyi;
	}
	/**
	 * 获取：评价建议
	 */
	public String getPingjiajianyi() {
		return pingjiajianyi;
	}
	/**
	 * 设置：员工工号
	 */
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	/**
	 * 获取：员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
	/**
	 * 设置：员工姓名
	 */
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
	/**
	 * 设置：店铺名称
	 */
	public void setDianpumingcheng(String dianpumingcheng) {
		this.dianpumingcheng = dianpumingcheng;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getDianpumingcheng() {
		return dianpumingcheng;
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
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
