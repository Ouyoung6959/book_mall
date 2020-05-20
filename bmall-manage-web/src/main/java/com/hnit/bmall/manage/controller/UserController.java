package com.hnit.bmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hnit.bmall.bean.User;
import com.hnit.bmall.manage.utils.RespCode;
import com.hnit.bmall.manage.utils.RespEntity;
import com.hnit.bmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Ouyoung
 * @date 2020/4/20
 **/
@Controller
@CrossOrigin
public class UserController {

    @Reference
    UserService userService ;
    @RequestMapping(value = "/user/logout" ,method = RequestMethod.POST)
    @ResponseBody
    public RespEntity  logout( ) {

        return new RespEntity(RespCode.SUCCESS,"success");
    }



    @RequestMapping(value = "/user/info" ,method = RequestMethod.GET)
    @ResponseBody
    public RespEntity  getInfo(  @RequestParam(value = "token",required = false) String username) {
        User user = userService.getUserById(Integer.parseInt(username));
        Map<String,Object> map =new HashMap<>();
        List<String> list =new ArrayList<>();
        if(user !=null){
            map.put("username",user.getUsername());
            map.put("name",user.getName());
            map.put("avatar",user.getAvatar());
            map.put("introduction",user.getIntroduction());
            list.add(user.getRole());
            map.put("roles",list);

        }

        return new RespEntity(RespCode.SUCCESS,map);
    }

    @RequestMapping(value = "/user/login" ,method = RequestMethod.POST)
    @ResponseBody
    public  RespEntity getUser(  @RequestBody User user){
        User newUser = userService.getUserById(user.getUsername());
        String role = user.getRole();
        Map<String,Object> map =new HashMap<>();
        map.put("token",newUser.getUsername());

        return new RespEntity(RespCode.SUCCESS,map);
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(  ){


        return "hello" ;
    }


}
