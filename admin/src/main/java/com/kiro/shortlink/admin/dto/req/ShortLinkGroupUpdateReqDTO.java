package com.kiro.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240407 21:29
 * @desc 短链接分组更新请求参数
 */
@Data
public class ShortLinkGroupUpdateReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名
     */
    private String name;
}
