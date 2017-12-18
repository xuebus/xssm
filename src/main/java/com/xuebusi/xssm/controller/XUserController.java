package com.xuebusi.xssm.controller;

import com.xuebusi.xssm.pojo.XUser;
import com.xuebusi.xssm.service.XUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by SYJ on 2017/12/18.
 */
@Controller
@RequestMapping(value = "/user")
public class XUserController {

    @Autowired
    private XUserService userService;

    @RequestMapping
    @ResponseBody
    public XUser list() {
        return userService.selectByExample(1);
    }

}
