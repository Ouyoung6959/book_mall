package com.hnit.bmall.book.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.hnit.bmall.bean.*;
import com.hnit.bmall.service.CatalogInfoService;
import com.hnit.bmall.utils.RespCode;
import com.hnit.bmall.utils.RespEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ouyoung
 * @date 2020/4/30
 **/
@Controller
@CrossOrigin
public class CatalogInfoController {

    @Reference
    CatalogInfoService catalogInfoService;

    @RequestMapping(value = "/getCatalog1" ,method = RequestMethod.POST)
    @ResponseBody
    public RespEntity getCatalog1(){
        List<PmsBaseCatalog1> catalog1 = catalogInfoService.getCatalog1();
        return new RespEntity(RespCode.SUCCESS,catalog1);
    }

    @RequestMapping(value = "/getCatalog2" ,method = RequestMethod.POST)
    @ResponseBody
    public RespEntity getCatalog2(@RequestParam(value = "catalog1Id" ,required = false) Integer catalog1Id){
        List<PmsBaseCatalog2> catalog2 = catalogInfoService.getCatalog2(catalog1Id);
        return new RespEntity(RespCode.SUCCESS,catalog2);
    }

    @RequestMapping(value = "/attrInfoList" ,method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getAttrInfoList( Integer catalog2Id){

        List<PmsBaseAttrInfo> attrInfoList = catalogInfoService.getAttrInfoList(catalog2Id);
        return new RespEntity(RespCode.SUCCESS,attrInfoList);
    }


    @RequestMapping(value = "/saveAttrInfo" ,method = RequestMethod.POST)
    @ResponseBody
    public RespEntity saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        catalogInfoService.updateOrAddPmsBaseAttrInfo(pmsBaseAttrInfo);

        return new RespEntity(RespCode.SUCCESS,null);
    }


    @RequestMapping(value = "/getAttrValueList" ,method = RequestMethod.POST)
    @ResponseBody
    public RespEntity getAttrValueList(@RequestParam(value="attrId",required = false) Integer attrId   ){
        List<PmsBaseAttrValue> attrValueList = catalogInfoService.getAttrValueList(attrId);
        return new RespEntity(RespCode.SUCCESS,attrValueList);

    }


    @RequestMapping(value = "/deleteAttrValue" ,method = RequestMethod.GET)
    @ResponseBody
    public RespEntity deleteAttrValue( Integer attrValueId   ){
        System.out.println(attrValueId);
        catalogInfoService.removeAttrValueById(attrValueId);
        return new RespEntity(RespCode.SUCCESS,null);

    }





}
