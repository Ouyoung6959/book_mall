package com.hnit.bmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hnit.bmall.bean.UmsMember;
import com.hnit.bmall.service.UserService;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Ouyoung
 * @date 2020/4/20
 **/
@Controller
@CrossOrigin
public class UserController {

    @Reference
    UserService userService ;

    @RequestMapping("/bmall-admin/user/login")
    @ResponseBody
    public String getUser(@PathVariable("userid") String userid){

        userService.getUserById(userid);

        return "hello user" ;
    }

//    @RequestMapping("getAllUser")
//    @ResponseBody
//    public List<UmsMember> getAllUser(){
//
//        List<UmsMember> allUser = userService.getAllUser();
//        for (UmsMember umsMember :allUser){
//            System.out.println(umsMember.toString());
//        }
//
//
//        return  allUser;
//
//    }


}
