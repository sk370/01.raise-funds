package com.atguigu.crowd.mysql.service;

import java.util.List;

import com.atguigu.crowd.entity.vo.DetailProjectVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.entity.vo.ProjectVO;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ProjectService
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/09 22:17
 */
public interface ProjectService {
    void saveProject(ProjectVO projectVO, Integer memberId);

    /**
     * 首页展示数据
     * 
     * @return
     */
    List<PortalTypeVO> getPortalTypeVO();

    /**
     * 项目详情页数据
     * 
     * @param projectId
     * @return
     */
    DetailProjectVO getDetailProjectVO(Integer projectId);
}
