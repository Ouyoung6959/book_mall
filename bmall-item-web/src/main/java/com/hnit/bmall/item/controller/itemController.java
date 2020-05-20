package com.hnit.bmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hnit.bmall.bean.PmsBookImages;
import com.hnit.bmall.bean.PmsBookInfo;
import com.hnit.bmall.service.AttrValueService;
import com.hnit.bmall.service.BookInfoService;
import com.hnit.bmall.service.CatalogInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Ouyoung
 * @date 2020/5/11
 **/
@Controller
public class itemController {
    @Reference
    BookInfoService bookInfoService ;

    @Reference
    AttrValueService attrValueService;

    @Reference
    CatalogInfoService catalogInfoService;

    @RequestMapping("/item/{bid}.html")
    public String item(@PathVariable Integer bid,ModelMap modelMap){
        PmsBookInfo bookInfo = bookInfoService.getBookById(bid);
        List<Map<String, Object>> attrInfos = attrValueService.getAttrInfo(bid);
        for (Map<String, Object> attrInfo:attrInfos){
            System.out.println(attrInfo);
        }

        List<PmsBookInfo> associateBooks =bookInfoService.getAssociateBook(bid);
        List<PmsBookImages> bookImages = bookInfoService.getImages(bid);
        Map<String, Object> catalogs = catalogInfoService.getCatalogs(bid);
        modelMap.put("attrInfos",attrInfos);
        modelMap.put("bookInfo",bookInfo);
        modelMap.put("associateBooks",associateBooks);
        modelMap.put("bookImages",bookImages);
        modelMap.put("catalogs",catalogs);
        return  "item";
    }
    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.put("hello","hello");
        return  "index";
    }
}
