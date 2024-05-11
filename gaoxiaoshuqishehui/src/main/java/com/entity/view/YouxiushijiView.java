package com.entity.view;

import com.entity.YouxiushijiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 优秀事迹栏目
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("youxiushiji")
public class YouxiushijiView extends YouxiushijiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 事迹类型的值
		*/
		private String youxiushijiValue;



	public YouxiushijiView() {

	}

	public YouxiushijiView(YouxiushijiEntity youxiushijiEntity) {
		try {
			BeanUtils.copyProperties(this, youxiushijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 事迹类型的值
			*/
			public String getYouxiushijiValue() {
				return youxiushijiValue;
			}
			/**
			* 设置： 事迹类型的值
			*/
			public void setYouxiushijiValue(String youxiushijiValue) {
				this.youxiushijiValue = youxiushijiValue;
			}











}
