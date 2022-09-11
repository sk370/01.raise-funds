package com.atguigu.crowd.mysql.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crowd.entity.vo.ProjectVO;
import com.atguigu.crowd.mysql.service.ProjectService;
import com.atguigu.crowd.util.ResultEntity;

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

    @RequestMapping("/create/confirm")
    ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO,
        @RequestParam("memberId") Integer memberId) {
        try {
            projectService.saveProject(projectVO, memberId);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
}
