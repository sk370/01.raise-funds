package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className PortalProjectVO
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/11 22:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortalProjectVO {

    private Integer projectId;
    private String projectName;
    private String headerPicturePath;
    private Integer money;
    private String deployDate;
    private Integer percentage;
    private Integer supporter;
}
