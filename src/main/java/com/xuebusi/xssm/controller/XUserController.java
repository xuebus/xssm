package com.xuebusi.xssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuebusi.xssm.common.XResult;
import com.xuebusi.xssm.pojo.XUser;
import com.xuebusi.xssm.pojo.XUserExample;
import com.xuebusi.xssm.service.XUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SYJ on 2017/12/18.
 */
@Controller
@RequestMapping(value = "/user")
public class XUserController {

    @Autowired
    private XUserService userService;

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}")
    @ResponseBody
    public XUser get(@PathVariable("id") Integer id) {
        return userService.selectByPrimaryKey(id);
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public List<XUser> list() {
        return userService.findAll();
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list2")
    @ResponseBody
    public XResult list(@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize) {
        return userService.findPage(pageNum, pageSize);
    }

    /**
     * 添加用户
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public int insert() {
        XUser user = new XUser();
        user.setName("王五");
        user.setAge(25);
        user.setPhone("13910108899");
        user.setAddress("重庆");
        return userService.insert(user);
    }

}
