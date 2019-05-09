package com.sun.controller;

// slf4j.Logger
import com.sun.model.User;
import com.sun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
// /user/**
public class UserController {
    private static Logger log= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // /user/test?id=1
    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("userId:"+userId);
        User user=null;
        if (userId==1) {
            user = new User();
            user.setUserId(1);
            user.setPassword("123");
            user.setUserName("java");
        }

        log.debug(user.toString());
        model.addAttribute("user", user);
        return "index";
    }

    // /user/showUser?id=1
    @RequestMapping(value="/showUser",method=RequestMethod.GET)
    public String toIndex(HttpServletRequest request,Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("userId:"+userId);
        User user = userService.getUserById(userId);
        log.debug(user.toString());
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping(value="/insert",method=RequestMethod.GET)
    public int insert(HttpServletRequest request,Model model){
        return 0;
    }
}
