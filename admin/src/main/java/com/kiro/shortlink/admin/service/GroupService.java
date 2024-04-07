package com.kiro.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kiro.shortlink.admin.dao.entity.GroupDO;
import com.kiro.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.kiro.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.kiro.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

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

    /**
     * 查询短链接分组集合
     * @return 用户短链接分组集合
     */
    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * 修改短链接分组名称
     *
     * @param requestParam 修改链接分组参数
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * 删除短链接分组
     *
     * @param gid 短链接分组标识
     */
    void deleteGroup(String gid);

    /**
     * 短链接分组排序
     *
     * @param requestParam 短链接分组排序参数
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
