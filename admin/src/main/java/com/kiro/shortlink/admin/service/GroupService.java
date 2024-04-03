package com.kiro.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kiro.shortlink.admin.dao.entity.GroupDO;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240403 17:17
 * @desc 短链接分组接口层
 */

public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短链接分组
     *
     * @param groupName 分组名称
     */
    void saveGroup(String groupName);

    /**
     * 新增短链接分组
     *
     * @param username  用户名
     * @param groupName 分组名称
     */
    void saveGroup(String username, String groupName);
}
