package com.atguigu.crowd.mysql.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crowd.mysql.service.ProjectService;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ProjectProvierHandler
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/09 22:17
 */
@RestController
public class ProjectProvierHandler {
    @Autowired
    private ProjectService projectService;
}
