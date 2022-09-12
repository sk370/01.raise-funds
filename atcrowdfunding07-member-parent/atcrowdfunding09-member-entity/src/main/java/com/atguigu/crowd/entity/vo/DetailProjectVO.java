package com.atguigu.crowd.entity.vo;

import java.util.List;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className DetailProjectVO
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/12 11:16
 */
public class DetailProjectVO {
    private Integer projectId;
    private String projectName;
    private String projectDesc;
    private Integer followerCount;
    private Integer status;
    private Integer day;
    private String statusText;
    private Integer money;
    private Integer supportMoney;
    private Integer percentage;
    private String deployDate;
    private Integer lastDay;
    private Integer supporterCount;
    private String headerPicturePath;
    private List<String> detailPicturePathList;
    private List<DetailReturnVO> detailReturnVOList;

}
