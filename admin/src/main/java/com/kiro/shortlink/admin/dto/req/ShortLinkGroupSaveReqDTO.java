package com.kiro.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240403 19:42
 * @desc 短链接分组保存请求DTO
 */
@Data
public class ShortLinkGroupSaveReqDTO {

    /**
     * 分组名称
     */
    private String name;
}
