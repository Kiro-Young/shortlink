package com.kiro.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kiro.shortlink.admin.dao.entity.GroupDO;
import com.kiro.shortlink.admin.dao.mapper.GroupMapper;
import com.kiro.shortlink.admin.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Kiro
 * @project shortlink
 * @time 20240403 17:19
 * @desc 短链接分组接口实现层
 */
@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

}
