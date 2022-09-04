package com.atguigu.crowd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.AdminExample;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectAdminByKeyword(String keyword);

    /**
     * 自定义删除用户角色
     * 
     * @param adminId
     */
    void deleteRelationship(Integer adminId);

    /**
     * 自定义保存用户角色
     * 
     * @param adminId
     * @param roleIdList
     */
    void saveRelationship(@Param("adminId") Integer adminId, @Param("roleIdList") List<Integer> roleIdList);// 由于mapper.xml中使用到了foreach标签遍历roleIdList，而roleIdList是自定义标签，所以需要使用@param注解
}