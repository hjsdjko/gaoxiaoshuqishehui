package com.entity.vo;

import com.entity.HuodongbaomingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 活动报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huodongbaoming")
public class HuodongbaomingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
