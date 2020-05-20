package com.hnit.bmall.book.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hnit.bmall.bean.PmsBaseAttrInfo;
import com.hnit.bmall.bean.PmsBaseAttrValue;
import com.hnit.bmall.bean.PmsBookInfo;
import com.hnit.bmall.bean.User;
import com.hnit.bmall.book.util.PmsUploadUtil;
import com.hnit.bmall.service.BookInfoService;
import com.hnit.bmall.utils.RespCode;
import com.hnit.bmall.utils.RespEntity;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ouyoung
 * @date 2020/5/3
 **/
@Controller
@CrossOrigin
public class BookInfoController {

    @Reference
    BookInfoService bookInfoService ;

    @RequestMapping(value = "/role/deleteRole",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity deleteRole(Integer id){
        bookInfoService.deleteRole(id);
        return new RespEntity(RespCode.SUCCESS,null);
    }

    @RequestMapping(value = "/role/updateRole",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity updateRole(@RequestBody Map<String,Object> map){
        bookInfoService.updateRole(map);
        return new RespEntity(RespCode.SUCCESS,null);
    }

    @RequestMapping(value = "/role/addRole",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addRole(@RequestBody Map<String,Object> map){
         User user = bookInfoService.addRole(map);
        return new RespEntity(RespCode.SUCCESS,user);
    }

    @RequestMapping(value = "/role/roles",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getRoles(){

        List<User> roles = bookInfoService.getRoles();
        List<Map<String,Object>> list =new ArrayList<>();
        for (User role:roles){
            HashMap<String, Object> map = new HashMap<>();
            List<Object> routes = bookInfoService.getRoutes(role.getUsername());
            JSONArray route = JSONArray.fromObject(routes);
            map.put("username",role.getUsername());
            map.put("name",role.getName());
            map.put("role",role.getRole());
            map.put("introduction",role.getIntroduction());
            map.put("avatar",role.getAvatar());
            map.put("routes",route);
            list.add(map);
        }

        return new RespEntity(RespCode.SUCCESS,list);
    }

    @RequestMapping(value = "/role/routes",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getRoutes(@RequestParam("username") Integer  username){

        List<Object> list = bookInfoService.getRoutes(username);
        JSONArray routes = JSONArray.fromObject(list);
        return new RespEntity(RespCode.SUCCESS,routes);
    }

    @RequestMapping(value = "/saveBookInfo",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity saveBookInfo(@RequestBody Map<Object,Object> bookInfo){

        bookInfoService.saveBookInfo(bookInfo);

        return new RespEntity(RespCode.SUCCESS,null);
    }

    @RequestMapping(value = "/fileUpload")
    @ResponseBody
    public RespEntity fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String image_url = PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(image_url);
        return new RespEntity(RespCode.SUCCESS,image_url);
    }

    @RequestMapping(value = "/getBaseAttrList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getBaseAttrList (){
        List<PmsBaseAttrInfo> baseAttrList = bookInfoService.getBaseAttrList();
        return new RespEntity(RespCode.SUCCESS,baseAttrList);
    }

    @RequestMapping(value = "/getBaseValueList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getBaseValueList  (Integer attrId){
        System.out.println(attrId);
        List<PmsBaseAttrValue> baseValueList = bookInfoService.getBaseValueList(attrId);
        return new RespEntity(RespCode.SUCCESS,baseValueList);
    }

    @RequestMapping(value = "/deleteBookInfo",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity deleteBookInfo (@RequestBody PmsBookInfo bookInfo){
        Integer integer = bookInfoService.deleteInfo(bookInfo);
        if(integer <0 ){
            return new RespEntity(RespCode.WARN,null);
        }
        return new RespEntity(RespCode.SUCCESS,null);
    }

    @RequestMapping(value = "/updateBookInfo",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity updateBookInfo (@RequestBody PmsBookInfo bookInfo){
        Integer integer = bookInfoService.saveInfo(bookInfo);
        if(integer <0 ){
            return new RespEntity(RespCode.WARN,null);
        }
        return new RespEntity(RespCode.SUCCESS,null);
    }


    @RequestMapping(value = "/getBookList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getBookList (Integer catalog2Id){
        List<PmsBookInfo> bookList = bookInfoService.getBookList(catalog2Id);
        return new RespEntity(RespCode.SUCCESS,bookList);
    }

}
