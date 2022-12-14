package com.atguigu.crowd.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crowd.entity.po.MemberConfirmInfoPO;
import com.atguigu.crowd.entity.po.MemberConfirmInfoPOExample;

public interface MemberConfirmInfoPOMapper {
    int countByExample(MemberConfirmInfoPOExample example);

    int deleteByExample(MemberConfirmInfoPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberConfirmInfoPO record);

    int insertSelective(MemberConfirmInfoPO record);

    List<MemberConfirmInfoPO> selectByExample(MemberConfirmInfoPOExample example);

    MemberConfirmInfoPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberConfirmInfoPO record,
        @Param("example") MemberConfirmInfoPOExample example);

    int updateByExample(@Param("record") MemberConfirmInfoPO record,
        @Param("example") MemberConfirmInfoPOExample example);

    int updateByPrimaryKeySelective(MemberConfirmInfoPO record);

    int updateByPrimaryKey(MemberConfirmInfoPO record);
}