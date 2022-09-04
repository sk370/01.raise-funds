package com.atguigu.crowd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crowd.entity.Auth;
import com.atguigu.crowd.entity.AuthExample;

public interface AuthMapper {
    int countByExample(AuthExample example);

    int deleteByExample(AuthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Auth record);

    int insertSelective(Auth record);

    List<Auth> selectByExample(AuthExample example);

    Auth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByExample(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);

    /**
     * 自定义查询：利用角色和权限的中间表查询权限id
     * 
     * @return
     */
    List<Integer> selectAssignedAuthIdByRoleId(Integer roleId);

    /**
     * 自定义：删除所有旧的角色和权限的关系
     * 
     * @param roleId
     */
    void deleteOldRelationship(Integer roleId);

    /**
     * 自定义：添加新的角色和权限的关系
     * 
     * @param roleId
     * @param authIdList
     */
    void insertNewRelationship(@Param("roleId") Integer roleId, @Param("authIdList") List<Integer> authIdList);
}