package com.atguigu.crowd.entity.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className DetailProjectVO
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/12 11:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailProjectVO {
    private Integer projectId;
    private String projectName;
    private String projectDesc;
    private Integer followerCount;
    private Integer status;// 项目状态
    private Integer day;// 众筹周期
    private String statusText;
    private Integer money;
    private Integer supportMoney;
    private Integer percentage;
    private String deployDate;
    private Integer lastDay;// 剩余天数
    private Integer supporterCount;
    private String headerPicturePath;
    private List<String> detailPicturePathList;
    private List<DetailReturnVO> detailReturnVOList;

}
