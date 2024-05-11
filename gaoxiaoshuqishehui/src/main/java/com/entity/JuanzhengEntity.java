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
 * 爱心捐物
 *
 * @author 
 * @email
 */
@TableName("juanzheng")
public class JuanzhengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JuanzhengEntity() {

	}

	public JuanzhengEntity(T t) {
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
        return "Juanzheng{" +
            "id=" + id +
            ", juanzhengName=" + juanzhengName +
            ", juanzhengTypes=" + juanzhengTypes +
            ", juanzhengPhoto=" + juanzhengPhoto +
            ", juanzhengContent=" + juanzhengContent +
            ", createTime=" + createTime +
        "}";
    }
}
