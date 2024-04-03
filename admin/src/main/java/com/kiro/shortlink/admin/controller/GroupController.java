package com.kiro.shortlink.admin.controller;

import com.kiro.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

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


}
