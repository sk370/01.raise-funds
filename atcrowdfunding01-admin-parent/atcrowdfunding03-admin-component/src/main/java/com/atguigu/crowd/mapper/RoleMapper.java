package com.atguigu.crowd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.entity.RoleExample;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 自定义关键词查询
     * 
     * @param keyword
     * @return
     */
    List<Role> selectRoleByKeyword(String keyword);
}