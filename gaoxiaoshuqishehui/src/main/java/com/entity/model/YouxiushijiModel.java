package com.entity.model;

import com.entity.YouxiushijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 优秀事迹栏目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YouxiushijiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String youxiushijiName;


    /**
     * 相关人物
     */
    private String youxiushijiRenwu;


    /**
     * 事迹类型
     */
    private Integer youxiushijiTypes;


    /**
     * 图片
     */
    private String youxiushijiPhoto;


    /**
     * 详情
     */
    private String youxiushijiContent;


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
	 * 获取：标题
	 */
    public String getYouxiushijiName() {
        return youxiushijiName;
    }


    /**
	 * 设置：标题
	 */
    public void setYouxiushijiName(String youxiushijiName) {
        this.youxiushijiName = youxiushijiName;
    }
    /**
	 * 获取：相关人物
	 */
    public String getYouxiushijiRenwu() {
        return youxiushijiRenwu;
    }


    /**
	 * 设置：相关人物
	 */
    public void setYouxiushijiRenwu(String youxiushijiRenwu) {
        this.youxiushijiRenwu = youxiushijiRenwu;
    }
    /**
	 * 获取：事迹类型
	 */
    public Integer getYouxiushijiTypes() {
        return youxiushijiTypes;
    }


    /**
	 * 设置：事迹类型
	 */
    public void setYouxiushijiTypes(Integer youxiushijiTypes) {
        this.youxiushijiTypes = youxiushijiTypes;
    }
    /**
	 * 获取：图片
	 */
    public String getYouxiushijiPhoto() {
        return youxiushijiPhoto;
    }


    /**
	 * 设置：图片
	 */
    public void setYouxiushijiPhoto(String youxiushijiPhoto) {
        this.youxiushijiPhoto = youxiushijiPhoto;
    }
    /**
	 * 获取：详情
	 */
    public String getYouxiushijiContent() {
        return youxiushijiContent;
    }


    /**
	 * 设置：详情
	 */
    public void setYouxiushijiContent(String youxiushijiContent) {
        this.youxiushijiContent = youxiushijiContent;
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
