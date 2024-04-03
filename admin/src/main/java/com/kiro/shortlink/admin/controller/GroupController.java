package com.kiro.shortlink.admin.controller;

import com.kiro.shortlink.admin.common.convention.result.Result;
import com.kiro.shortlink.admin.common.convention.result.Results;
import com.kiro.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.kiro.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.kiro.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240403 17:23
 * @desc 短链接分组控制层
 */

@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * 新增短链接分组
     * @param shortLinkGroupSaveReqDTO 分组名称
     */
    @PostMapping("/api/short-link/admin/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO shortLinkGroupSaveReqDTO) {
        groupService.saveGroup(shortLinkGroupSaveReqDTO.getName());
        return Results.success();
    }

    /**
     * 查询短链接分组集合
     */
    @GetMapping("/api/short-link/admin/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

}
