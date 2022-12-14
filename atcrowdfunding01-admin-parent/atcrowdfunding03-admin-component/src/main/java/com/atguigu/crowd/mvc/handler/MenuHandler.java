/**
 * 
 */
package com.atguigu.crowd.mvc.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.service.api.MenuService;
import com.atguigu.crowd.util.ResultEntity;

/**
 * @ClassName: MenuController
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月2日 下午5:09:06
 * @param:
 */
@Controller
public class MenuHandler {
    @Autowired
    private MenuService menuService;

    /**
     * 删除节点
     * 
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/menu/delete.json")
    public ResultEntity<String> delete(@RequestParam("id") Integer id) {
        menuService.delete(id);
        return ResultEntity.successWithoutData();
    }

    /**
     * 修改节点
     * 
     * @param menu
     * @return
     */
    @ResponseBody
    @RequestMapping("/menu/update.json")
    public ResultEntity<String> update(Menu menu) {
        menuService.update(menu);
        return ResultEntity.successWithoutData();
    }

    /**
     * 添加节点
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping("/menu/save.json")
    public ResultEntity<String> save(Menu menu) {
        System.out.println(menu);
        menuService.save(menu);
        return ResultEntity.successWithoutData();
    }

    /**
     * 优化组装树形结构
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping("/menu/get/whole/tree.json")
    public ResultEntity<Menu> getWholeTreeNew() {
        List<Menu> list = menuService.getAll();

        // 包装成树形结构
        Menu root = null;// 根结点
        Map<Integer, Menu> menuMap = new HashMap<>();// 创建一个存放id和menu的集合，便于查找父节点

        for (Menu menu : list) {
            Integer id = menu.getId();// 当前节点的id
            menuMap.put(id, menu);
        }

        for (Menu menu : list) {
            Integer pid = menu.getPid();// 当前节点的pid
            // 判断menu是不是根节点
            if (pid == null) {
                root = menu;
                continue;
            }

            Menu father = menuMap.get(pid);
            father.getChildren().add(menu);// 父节点是个list集合，所以能add

        }
        return ResultEntity.successWithData(root);
    }

    /**
     * 嵌套循环组装，事件复杂度On2
     * 
     * @return
     */
    public ResultEntity<Menu> getWholeTreeOld() {
        List<Menu> list = menuService.getAll();

        // 包装成树形结构
        Menu root = null;// 根结点
        for (Menu menu : list) {

            Integer pid = menu.getPid();// 当前节点的pid

            // 判断menu是不是根节点
            if (pid == null) {
                root = menu;
                continue;
            }

            // 查找menu的父节点
            for (Menu father : list) {
                Integer id = father.getId();
                if (Objects.equals(pid, id)) {
                    father.getChildren().add(menu);// 父节点是个list集合，所以能add
                    break;// 一个子节点只有一个父节点，找到即可跳出内层循环
                }
            }
        }
        return ResultEntity.successWithData(root);
    }
}
