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
 * 活动报名
 *
 * @author 
 * @email
 */
@TableName("huodongbaoming")
public class HuodongbaomingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuodongbaomingEntity() {

	}

	public HuodongbaomingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 活动
     */
    @TableField(value = "huodongfabu_id")

    private Integer huodongfabuId;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 兴趣爱好
     */
    @TableField(value = "huodongbaoming_xingqu")

    private String huodongbaomingXingqu;


    /**
     * 意向岗位
     */
    @TableField(value = "huodongbaoming_yixiang")

    private String huodongbaomingYixiang;


    /**
     * 审核结果
     */
    @TableField(value = "huodongbaoming_yesno_types")

    private Integer huodongbaomingYesnoTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：活动
	 */
    public Integer getHuodongfabuId() {
        return huodongfabuId;
    }


    /**
	 * 获取：活动
	 */

    public void setHuodongfabuId(Integer huodongfabuId) {
        this.huodongfabuId = huodongfabuId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：兴趣爱好
	 */
    public String getHuodongbaomingXingqu() {
        return huodongbaomingXingqu;
    }


    /**
	 * 获取：兴趣爱好
	 */

    public void setHuodongbaomingXingqu(String huodongbaomingXingqu) {
        this.huodongbaomingXingqu = huodongbaomingXingqu;
    }
    /**
	 * 设置：意向岗位
	 */
    public String getHuodongbaomingYixiang() {
        return huodongbaomingYixiang;
    }


    /**
	 * 获取：意向岗位
	 */

    public void setHuodongbaomingYixiang(String huodongbaomingYixiang) {
        this.huodongbaomingYixiang = huodongbaomingYixiang;
    }
    /**
	 * 设置：审核结果
	 */
    public Integer getHuodongbaomingYesnoTypes() {
        return huodongbaomingYesnoTypes;
    }


    /**
	 * 获取：审核结果
	 */

    public void setHuodongbaomingYesnoTypes(Integer huodongbaomingYesnoTypes) {
        this.huodongbaomingYesnoTypes = huodongbaomingYesnoTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huodongbaoming{" +
            "id=" + id +
            ", huodongfabuId=" + huodongfabuId +
            ", xueshengId=" + xueshengId +
            ", huodongbaomingXingqu=" + huodongbaomingXingqu +
            ", huodongbaomingYixiang=" + huodongbaomingYixiang +
            ", huodongbaomingYesnoTypes=" + huodongbaomingYesnoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
