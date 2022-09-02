package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;

public interface AdminService {
    /**
     * 
     * @param admin
     */
    void saveAdmin(Admin admin);

    /**
     * @return
     */
    List<Admin> getAll();

    /**
     * @param loginAcct
     * @param userPswd
     * @return
     */
    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    /**
     * @param adminId
     */
    void remove(Integer adminId);

    /**
     * @param adminId
     * @return
     */
    Admin getadminById(Integer adminId);

    /**
     * @param admin
     */
    void update(Admin admin);

}
