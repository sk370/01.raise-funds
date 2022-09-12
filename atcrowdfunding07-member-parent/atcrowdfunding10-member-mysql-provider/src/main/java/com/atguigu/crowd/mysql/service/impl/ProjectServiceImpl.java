package com.atguigu.crowd.mysql.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crowd.entity.po.MemberConfirmInfoPO;
import com.atguigu.crowd.entity.po.MemberLaunchInfoPO;
import com.atguigu.crowd.entity.po.ProjectPO;
import com.atguigu.crowd.entity.po.ReturnPO;
import com.atguigu.crowd.entity.vo.*;
import com.atguigu.crowd.mysql.mapper.*;
import com.atguigu.crowd.mysql.service.ProjectService;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ProjectServiceImpl
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/09 22:17
 */
@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectPOMapper projectPOMapper;
    @Autowired
    private ProjectItemPicPOMapper projectItemPicPOMapper;
    @Autowired
    private MemberLaunchInfoPOMapper memberLaunchInfoPOMapper;
    @Autowired
    private MemberConfirmInfoPOMapper memberConfirmInfoPOMapper;
    @Autowired
    private ReturnPOMapper returnPOMapper;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void saveProject(ProjectVO projectVO, Integer memberId) {
        // 1. 保存ProjectPO对象
        ProjectPO projectPO = new ProjectPO();
        BeanUtils.copyProperties(projectVO, projectPO);
        // 补充ProjectPO对象的信息
        projectPO.setMemberid(memberId);// 完善创建人
        String createDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        projectPO.setCreatedate(createDate);// 完善创建时间
        projectPO.setStatus(0);// 完善发布状态，表示即将开始

        // projectPO部分信息还没有，要等项目发布才能得到，所以选取insertSelective方法
        projectPOMapper.insertSelective(projectPO);// 这里修改了mapper.xml文件，设置了useGeneratedKeys="true"，以便获取主键
        Integer projectPOId = projectPO.getId();
        System.out.println("+++++++++++++++++++++++++++++" + projectPOId);

        // 2. 保存项目、分类的关联关系信息
        List<Integer> typeIdList = projectVO.getTypeIdList();
        projectPOMapper.insertTypeRelationship(typeIdList, projectPOId);

        // 3. 保存项目、标签的关联关系信息
        List<Integer> tagIdList = projectVO.getTagIdList();
        projectPOMapper.insertTagRelationship(tagIdList, projectPOId);

        // 4. 保存项目中详情图片的路径信息
        List<String> detailPicturePathList = projectVO.getDetailPicturePathList();
        projectItemPicPOMapper.insertPathList(projectPOId, detailPicturePathList);

        // 5. 保存项目发起人信息
        MemberLauchInfoVO memberLauchInfoVO = projectVO.getMemberLauchInfoVO();
        MemberLaunchInfoPO memberLaunchInfoPO = new MemberLaunchInfoPO();
        BeanUtils.copyProperties(memberLauchInfoVO, memberLaunchInfoPO);
        memberLaunchInfoPO.setMemberid(memberId);
        memberLaunchInfoPOMapper.insert(memberLaunchInfoPO);

        // 6. 保存项目回报信息
        List<ReturnVO> returnVOList = projectVO.getReturnVOList();
        List<ReturnPO> returnPOList = new ArrayList<>();
        for (ReturnVO returnVO : returnVOList) {
            ReturnPO returnPO = new ReturnPO();
            BeanUtils.copyProperties(returnVO, returnPO);
            returnPOList.add(returnPO);
        }
        returnPOMapper.insertReturnPOBatch(returnPOList, projectPOId);

        // 7. 保存项目的确认信息
        MemberConfirmInfoVO memberConfirmInfoVO = projectVO.getMemberConfirmInfoVO();
        MemberConfirmInfoPO memberConfirmInfoPO = new MemberConfirmInfoPO();
        BeanUtils.copyProperties(memberConfirmInfoVO, memberConfirmInfoPO);
        memberConfirmInfoPO.setMemberid(memberId);
        memberConfirmInfoPOMapper.insert(memberConfirmInfoPO);

    }

    @Override
    public List<PortalTypeVO> getPortalTypeVO() {
        return projectPOMapper.selectPortalTypeVOList();
    }
}
