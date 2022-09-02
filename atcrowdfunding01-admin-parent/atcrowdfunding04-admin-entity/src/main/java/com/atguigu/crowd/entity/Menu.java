package com.atguigu.crowd.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer id;

    private Integer pid;

    private String name;

    private String url;// 点击节点跳转的地址

    private String icon;

    private List<Menu> children = new ArrayList<>();// 包装子节点，同时为避免空指针异常，需要初始化

    private Boolean open = true;// 是否默认打开节点

    public Menu() {
        super();
    }

    public Menu(Integer id, Integer pid, String name, String url, String icon, List<Menu> children, Boolean open) {
        super();
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.children = children;
        this.open = open;
    }

    /**
     * @return the children
     */
    public List<Menu> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    /**
     * @return the open
     */
    public Boolean getOpen() {
        return open;
    }

    /**
     * @param open the open to set
     */
    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    @Override
    public String toString() {
        return "Menu [id=" + id + ", pid=" + pid + ", name=" + name + ", url=" + url + ", icon=" + icon + ", children="
            + children + ", open=" + open + "]";
    }

}