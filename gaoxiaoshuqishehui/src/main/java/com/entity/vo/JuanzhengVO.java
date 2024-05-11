package com.entity.vo;

import com.entity.JuanzhengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 爱心捐物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("juanzheng")
public class JuanzhengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物品名称
     */

    @TableField(value = "juanzheng_name")
    private String juanzhengName;


    /**
     * 物品类型
     */

    @TableField(value = "juanzheng_types")
    private Integer juanzhengTypes;


    /**
     * 物品图片
     */

    @TableField(value = "juanzheng_photo")
    private String juanzhengPhoto;


    /**
     * 物品详情
     */

    @TableField(value = "juanzheng_content")
    private String juanzhengContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：物品名称
	 */
    public String getJuanzhengName() {
        return juanzhengName;
    }


    /**
	 * 获取：物品名称
	 */

    public void setJuanzhengName(String juanzhengName) {
        this.juanzhengName = juanzhengName;
    }
    /**
	 * 设置：物品类型
	 */
    public Integer getJuanzhengTypes() {
        return juanzhengTypes;
    }


    /**
	 * 获取：物品类型
	 */

    public void setJuanzhengTypes(Integer juanzhengTypes) {
        this.juanzhengTypes = juanzhengTypes;
    }
    /**
	 * 设置：物品图片
	 */
    public String getJuanzhengPhoto() {
        return juanzhengPhoto;
    }


    /**
	 * 获取：物品图片
	 */

    public void setJuanzhengPhoto(String juanzhengPhoto) {
        this.juanzhengPhoto = juanzhengPhoto;
    }
    /**
	 * 设置：物品详情
	 */
    public String getJuanzhengContent() {
        return juanzhengContent;
    }


    /**
	 * 获取：物品详情
	 */

    public void setJuanzhengContent(String juanzhengContent) {
        this.juanzhengContent = juanzhengContent;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
