package com.atguigu.crowd.entity.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className PortalTypeVO
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/11 22:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortalTypeVO {
    private Integer id;
    private String name;
    private String remark;
    private List<PortalProjectVO> portalProjectVOList;
}
