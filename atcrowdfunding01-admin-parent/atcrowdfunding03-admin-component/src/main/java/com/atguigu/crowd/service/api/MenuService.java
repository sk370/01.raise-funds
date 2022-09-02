/**
 * 
 */
package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.Menu;

/**
 * @ClassName: MenuService
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月2日 下午5:08:14
 * @param:
 */
public interface MenuService {

    /**
     * @return
     * 
     */
    List<Menu> getAll();

}
