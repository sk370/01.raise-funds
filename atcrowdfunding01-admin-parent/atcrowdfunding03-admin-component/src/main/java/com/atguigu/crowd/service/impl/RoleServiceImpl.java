/**
 * 
 */
package com.atguigu.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.entity.RoleExample;
import com.atguigu.crowd.entity.RoleExample.Criteria;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: RoleServiceImpl
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月2日 上午9:08:25
 * @param:
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roleList = roleMapper.selectRoleByKeyword(keyword);
        return new PageInfo<>(roleList);
    }

    @Override
    public void saveRole(Role role) {
        // TODO 判断角色是否重复（首先要给数据库字段添加unique约束
        roleMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {
        // TODO 判断角色是否重复（首先要给数据库字段添加unique约束
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void removeByRoleIdAarry(List<Integer> roleIdList) {
        // TODO 进行逻辑删除
        RoleExample roleExample = new RoleExample();

        Criteria createCriteria = roleExample.createCriteria();// 创建查询条件
        createCriteria.andIdIn(roleIdList);// 给查询条件添加数据
        roleMapper.deleteByExample(roleExample);

    }

}
