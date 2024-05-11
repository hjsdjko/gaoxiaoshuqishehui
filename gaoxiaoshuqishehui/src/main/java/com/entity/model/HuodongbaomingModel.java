package com.entity.model;

import com.entity.HuodongbaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 活动报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuodongbaomingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 活动
     */
    private Integer huodongfabuId;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 兴趣爱好
     */
    private String huodongbaomingXingqu;


    /**
     * 意向岗位
     */
    private String huodongbaomingYixiang;


    /**
     * 审核结果
     */
    private Integer huodongbaomingYesnoTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：活动
	 */
    public Integer getHuodongfabuId() {
        return huodongfabuId;
    }


    /**
	 * 设置：活动
	 */
    public void setHuodongfabuId(Integer huodongfabuId) {
        this.huodongfabuId = huodongfabuId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：兴趣爱好
	 */
    public String getHuodongbaomingXingqu() {
        return huodongbaomingXingqu;
    }


    /**
	 * 设置：兴趣爱好
	 */
    public void setHuodongbaomingXingqu(String huodongbaomingXingqu) {
        this.huodongbaomingXingqu = huodongbaomingXingqu;
    }
    /**
	 * 获取：意向岗位
	 */
    public String getHuodongbaomingYixiang() {
        return huodongbaomingYixiang;
    }


    /**
	 * 设置：意向岗位
	 */
    public void setHuodongbaomingYixiang(String huodongbaomingYixiang) {
        this.huodongbaomingYixiang = huodongbaomingYixiang;
    }
    /**
	 * 获取：审核结果
	 */
    public Integer getHuodongbaomingYesnoTypes() {
        return huodongbaomingYesnoTypes;
    }


    /**
	 * 设置：审核结果
	 */
    public void setHuodongbaomingYesnoTypes(Integer huodongbaomingYesnoTypes) {
        this.huodongbaomingYesnoTypes = huodongbaomingYesnoTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
