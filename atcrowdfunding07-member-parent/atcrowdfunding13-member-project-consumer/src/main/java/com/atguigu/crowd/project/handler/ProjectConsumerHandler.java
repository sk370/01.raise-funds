package com.atguigu.crowd.project.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.crowd.api.MySqlRemoteService;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.vo.*;
import com.atguigu.crowd.project.config.OSSProperties;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ProjectConsumerHandler
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/10 08:24
 */
@Controller
public class ProjectConsumerHandler {
    @Autowired
    private OSSProperties ossProperties;
    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    /**
     * 项目详情页
     * 
     * @param projectId
     * @param model
     * @return
     */
    @RequestMapping("/get/project/detail/{projectId}")
    public String getProjcetDetail(@PathVariable("projectId") Integer projectId, Model model) {
        ResultEntity<DetailProjectVO> resultEntity = mySqlRemoteService.getDetailProjectVORemote(projectId);
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            DetailProjectVO detailProjectVO = resultEntity.getData();
            model.addAttribute("detailProjectVO", detailProjectVO);
        }
        return "project-show-detail";
    }

    /**
     * 保存发布项目时保存的信息
     * 
     * @param modelMap
     * @param session
     * @param memberConfirmInfoVO
     * @return
     */
    @RequestMapping("/create/confirm")
    public String saveConfirm(ModelMap modelMap, HttpSession session, MemberConfirmInfoVO memberConfirmInfoVO) {
        ProjectVO projectVO = (ProjectVO)session.getAttribute(CrowdConstant.ATTR_NAME_TEMPLATE_PROJECT);
        if (projectVO == null) {
            throw new RuntimeException(CrowdConstant.MESSAGE_TEMPLE_PROJECT_MISSING);
        }
        projectVO.setMemberConfirmInfoVO(memberConfirmInfoVO);
        // 将projectVO保存到远程的mysql服务中
        MemberLoginVO memberLoginVO = (MemberLoginVO)session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
        Integer memberId = memberLoginVO.getId();
        System.out.println(memberId);
        ResultEntity<String> saveResultEntity = mySqlRemoteService.saveProjectVORemote(projectVO, memberId);
        if (ResultEntity.FAILED.equals(saveResultEntity.getResult())) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveResultEntity.getMessage());
            return "project-confirm";
        }
        session.removeAttribute(CrowdConstant.ATTR_NAME_TEMPLATE_PROJECT);// 从redis中删除
        return "redirect:http://localhost:81/project/create/success";
    }

    /**
     * 回报页面的其他信息
     *
     * @param returnVO
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/create/save/return.json")
    public ResultEntity<String> saveReturn(ReturnVO returnVO, HttpSession session) {
        try {
            // 从redis的session中获取project对象
            ProjectVO projectVO = (ProjectVO)session.getAttribute(CrowdConstant.ATTR_NAME_TEMPLATE_PROJECT);
            if (projectVO == null) {
                return ResultEntity.failed(CrowdConstant.MESSAGE_TEMPLE_PROJECT_MISSING);
            }
            List<ReturnVO> returnVOList = projectVO.getReturnVOList();
            if (returnVOList == null || returnVOList.size() == 0) {
                returnVOList = new ArrayList<>();
                projectVO.setReturnVOList(returnVOList);// 注意：new时改变了returnVOList的指向，必须将它再放回到projectVO里
            }
            returnVOList.add(returnVO);
            session.setAttribute(CrowdConstant.ATTR_NAME_TEMPLATE_PROJECT, projectVO);// 这个session是redis中的，还要临时存到redis中去，所以需要设置
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * 回报页面上传的图片
     *
     * @param returnPicture
     * @return
     */
    @ResponseBody
    @RequestMapping("create/upload/return/picture.json")
    public ResultEntity<String> uploadRetrunPicture(@RequestParam("returnPicture") MultipartFile returnPicture) {
        // TODO 这里没有判断上传文件是否为空，一是可以在前端页面判断，二是判断是否为空，为空在请求域存放提示信息
        ResultEntity<String> returnPictureResultEntity = null;
        try {
            returnPictureResultEntity = CrowdUtil.uploadFileToOss(ossProperties.getEndPoint(),
                ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret(), returnPicture.getInputStream(),
                ossProperties.getBucketName(), returnPicture.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnPictureResultEntity;
    }

    /**
     * 接收表单数据
     *
     * @param projectVO 文本及选择信息
     * @param headerPicture 头图信息
     * @param detailPictureList 详细图信息
     * @param session 从redis获取，注意要引入springsession并配置
     * @param modelMap 操作失败时返回给前端的信息
     * @return
     */
    @RequestMapping("/create/project/information")
    public String saveProjectBasicInfo(ProjectVO projectVO, MultipartFile headerPicture,
        List<MultipartFile> detailPictureList, HttpSession session, ModelMap modelMap) throws IOException {
        // 1. 上传头图（要求头图必须上传）
        boolean headerPictureEmpty = headerPicture.isEmpty();
        if (!headerPictureEmpty) {// 为空表示没有上传，或者上传图片大小为0kb
            ResultEntity<String> headerPictureResultEntity = CrowdUtil.uploadFileToOss(ossProperties.getEndPoint(),
                ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret(), headerPicture.getInputStream(),
                ossProperties.getBucketName(), headerPicture.getOriginalFilename());
            String result = headerPictureResultEntity.getResult();
            if (ResultEntity.SUCCESS.equals(result)) {
                // 创建上传图片的访问地址
                String headerPicturePath = headerPictureResultEntity.getData();
                projectVO.setHeaderPicturePath(headerPicturePath);
            } else {
                modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE,
                    CrowdConstant.MESSAGE_HEADER_PICTURE_UPLOAD_FAILED);
                return "project-launch";
            }
        } else {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_HEADER_PICTURE_EMPTY);
            return "project-launch";
        }

        // 2. 上传详细图
        // 2.1 存放详情图片路径的集合
        List<String> detailPicturePathList = new ArrayList<>();
        if (detailPictureList == null || detailPictureList.size() == 0) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PICTURE_EMPTY);
            return "project-launch";
        }
        for (MultipartFile detailPicture : detailPictureList) {
            if (detailPicture.isEmpty()) {
                modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PICTURE_EMPTY);
                return "project-launch";
            }

            ResultEntity<String> detailPictureResultEntity = CrowdUtil.uploadFileToOss(ossProperties.getEndPoint(),
                ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret(), detailPicture.getInputStream(),
                ossProperties.getBucketName(), detailPicture.getOriginalFilename());
            String result = detailPictureResultEntity.getResult();
            if (ResultEntity.SUCCESS.equals(result)) {
                // 创建上传图片的访问地址
                String detailPicturePath = detailPictureResultEntity.getData();
                detailPicturePathList.add(detailPicturePath);
            } else {
                modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE,
                    CrowdConstant.MESSAGE_DETAIL_PICTURE_UPLOAD_FAILED);
                return "project-launch";
            }
        }
        projectVO.setDetailPicturePathList(detailPicturePathList);

        // 3. 将projectvo存放到redis（开发场景中，projectvo还要组合其他来源的vo，如消息中间件，等到全齐了才组合PO）
        // 由于使用了spring session，此时setAttribute已经不是简单的setAttribute了，因为session保存到redis了
        session.setAttribute(CrowdConstant.ATTR_NAME_TEMPLATE_PROJECT, projectVO);
        Object attribute = session.getAttribute(CrowdConstant.ATTR_NAME_TEMPLATE_PROJECT);
        System.out.println(attribute);
        return "redirect:http://localhost:81/project/return/info/page";// 关于是否写全路径避免被识别为不是同一个站点，不能共享session的问题
    }
}
