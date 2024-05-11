package com.entity.model;

import com.entity.JuanzhengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 爱心捐物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JuanzhengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物品名称
     */
    private String juanzhengName;


    /**
     * 物品类型
     */
    private Integer juanzhengTypes;


    /**
     * 物品图片
     */
    private String juanzhengPhoto;


    /**
     * 物品详情
     */
    private String juanzhengContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：物品名称
	 */
    public String getJuanzhengName() {
        return juanzhengName;
    }


    /**
	 * 设置：物品名称
	 */
    public void setJuanzhengName(String juanzhengName) {
        this.juanzhengName = juanzhengName;
    }
    /**
	 * 获取：物品类型
	 */
    public Integer getJuanzhengTypes() {
        return juanzhengTypes;
    }


    /**
	 * 设置：物品类型
	 */
    public void setJuanzhengTypes(Integer juanzhengTypes) {
        this.juanzhengTypes = juanzhengTypes;
    }
    /**
	 * 获取：物品图片
	 */
    public String getJuanzhengPhoto() {
        return juanzhengPhoto;
    }


    /**
	 * 设置：物品图片
	 */
    public void setJuanzhengPhoto(String juanzhengPhoto) {
        this.juanzhengPhoto = juanzhengPhoto;
    }
    /**
	 * 获取：物品详情
	 */
    public String getJuanzhengContent() {
        return juanzhengContent;
    }


    /**
	 * 设置：物品详情
	 */
    public void setJuanzhengContent(String juanzhengContent) {
        this.juanzhengContent = juanzhengContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
