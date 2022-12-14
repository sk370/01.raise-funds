package com.atguigu.crowd.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crowd.entity.po.ProjectPO;
import com.atguigu.crowd.entity.po.ProjectPOExample;
import com.atguigu.crowd.entity.vo.DetailProjectVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;

public interface ProjectPOMapper {
    int countByExample(ProjectPOExample example);

    int deleteByExample(ProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    List<ProjectPO> selectByExample(ProjectPOExample example);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByExample(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);

    // 自定义方法1
    void insertTypeRelationship(@Param("typeIdList") List<Integer> typeIdList,
        @Param("projectPOId") Integer projectPOId);

    // 自定义方法2
    void insertTagRelationship(@Param("tagIdList") List<Integer> tagIdList, @Param("projectPOId") Integer projectPOId);

    // 自定义方法3
    List<PortalTypeVO> selectPortalTypeVOList();

    // 自定义方法4
    DetailProjectVO selectDetailProjectVO(Integer projectId);
}