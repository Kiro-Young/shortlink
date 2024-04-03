package com.kiro.shortlink.admin.dao;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240403 17:39
 * @desc 基础实体类属性
 */
@Data
public class BaseDO {

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 删除标识：0未删除 1已删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;
}
