package com.entity.view;

import com.entity.HuodongbaomingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动报名
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huodongbaoming")
public class HuodongbaomingView extends HuodongbaomingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 审核结果的值
		*/
		private String huodongbaomingYesnoValue;
		/**
		* 审核结果的值
		*/
		private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//级联表 huodongfabu
			/**
			* 活动标题
			*/
			private String huodongfabuName;
			/**
			* 活动类型
			*/
			private Integer huodongfabuTypes;
				/**
				* 活动类型的值
				*/
				private String huodongfabuValue;
			/**
			* 活动封面
			*/
			private String huodongfabuPhoto;
			/**
			* 活动详情
			*/
			private String huodongfabuContent;

		//级联表 xuesheng
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 手机号
			*/
			private String xueshengPhone;
			/**
			* 年级
			*/
			private String xueshengNianji;
			/**
			* 照片
			*/
			private String xueshengPhoto;

	public HuodongbaomingView() {

	}

	public HuodongbaomingView(HuodongbaomingEntity huodongbaomingEntity) {
		try {
			BeanUtils.copyProperties(this, huodongbaomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核结果的值
			*/
			public String getHuodongbaomingYesnoValue() {
				return huodongbaomingYesnoValue;
			}
			/**
			* 设置： 审核结果的值
			*/
			public void setHuodongbaomingYesnoValue(String huodongbaomingYesnoValue) {
				this.huodongbaomingYesnoValue = huodongbaomingYesnoValue;
			}













				//级联表的get和set huodongfabu
					/**
					* 获取： 活动标题
					*/
					public String getHuodongfabuName() {
						return huodongfabuName;
					}
					/**
					* 设置： 活动标题
					*/
					public void setHuodongfabuName(String huodongfabuName) {
						this.huodongfabuName = huodongfabuName;
					}
					/**
					* 获取： 活动类型
					*/
					public Integer getHuodongfabuTypes() {
						return huodongfabuTypes;
					}
					/**
					* 设置： 活动类型
					*/
					public void setHuodongfabuTypes(Integer huodongfabuTypes) {
						this.huodongfabuTypes = huodongfabuTypes;
					}


						/**
						* 获取： 活动类型的值
						*/
						public String getHuodongfabuValue() {
							return huodongfabuValue;
						}
						/**
						* 设置： 活动类型的值
						*/
						public void setHuodongfabuValue(String huodongfabuValue) {
							this.huodongfabuValue = huodongfabuValue;
						}
					/**
					* 获取： 活动封面
					*/
					public String getHuodongfabuPhoto() {
						return huodongfabuPhoto;
					}
					/**
					* 设置： 活动封面
					*/
					public void setHuodongfabuPhoto(String huodongfabuPhoto) {
						this.huodongfabuPhoto = huodongfabuPhoto;
					}
					/**
					* 获取： 活动详情
					*/
					public String getHuodongfabuContent() {
						return huodongfabuContent;
					}
					/**
					* 设置： 活动详情
					*/
					public void setHuodongfabuContent(String huodongfabuContent) {
						this.huodongfabuContent = huodongfabuContent;
					}










				//级联表的get和set xuesheng
					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}
					/**
					* 获取： 年级
					*/
					public String getXueshengNianji() {
						return xueshengNianji;
					}
					/**
					* 设置： 年级
					*/
					public void setXueshengNianji(String xueshengNianji) {
						this.xueshengNianji = xueshengNianji;
					}
					/**
					* 获取： 照片
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}






}
