package com.kiro.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kiro.shortlink.admin.dao.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240403 17:11
 * @desc 短链接分组实体
 */
@Data
@TableName("t_group")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建分组用户名
     */
    private String username;

    /**
     * 分组排序
     */
    private Integer sortOrder;
}
