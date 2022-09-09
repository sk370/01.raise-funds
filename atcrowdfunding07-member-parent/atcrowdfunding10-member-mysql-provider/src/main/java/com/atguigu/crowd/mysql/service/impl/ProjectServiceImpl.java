package com.atguigu.crowd.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.mysql.mapper.ProjectPOMapper;
import com.atguigu.crowd.mysql.service.ProjectService;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ProjectServiceImpl
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/09 22:17
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectPOMapper projectPOMapper;
}
