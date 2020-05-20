package com.hnit.bmall.search.controler;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.hnit.bmall.bean.*;
import com.hnit.bmall.service.AttrValueService;
import com.hnit.bmall.service.BookInfoService;
import com.hnit.bmall.service.CatalogInfoService;
import com.hnit.bmall.service.SearchService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author Ouyoung
 * @date 2020/5/17
 **/
@Controller
public class searchController {
    @Reference
    CatalogInfoService catalogInfoService;
    @Reference
    SearchService searchService ;
    @Reference
    AttrValueService attrValueService ;

    @RequestMapping("getCatalog2")
    @ResponseBody
    public String  getCatalog2(){
        List<PmsBaseCatalog1> catalogs = catalogInfoService.getCatalog();
        String json = JSON.toJSONString(catalogs);
        return json;
    }

    @RequestMapping("list.html")
    public String  list(PmsSearchParams params ,ModelMap map){
        List<PmsSearchBook> searchBooks = searchService.list(params);
        map.put("searchBooks",searchBooks);

        Set<Integer> valueSet = new HashSet<Integer>();
        for (PmsSearchBook searchBook : searchBooks) {
            List<PmsBookAttrValue> pmsBookAttrValues = searchBook.getPmsBookAttrValues();
            for (PmsBookAttrValue pmsBookAttrValue : pmsBookAttrValues) {
                Integer valueId = pmsBookAttrValue.getValueId();
                valueSet.add(valueId);
            }
        }
        String[] delValueId = params.getValueId();
        if (valueSet !=null && valueSet.size() >0){
            List<PmsBaseAttrInfo> attrInfoList = attrValueService.getAttrValueListByValueId(valueSet);
            if (delValueId !=null ){
                List<PmsSearchCrumb> pmsSearchCrumbs = new ArrayList<>();
                for (String del : delValueId) {
                    Iterator<PmsBaseAttrInfo> iterator = attrInfoList.iterator();
                    PmsSearchCrumb pmsSearchCrumb = new PmsSearchCrumb();
                    pmsSearchCrumb.setValueId(Integer.parseInt(del));
                    pmsSearchCrumb.setUrlParam(getUrlParamForCrumb(params,del));
                    while (iterator.hasNext()){
                        PmsBaseAttrInfo pmsBaseAttrInfo = iterator.next();
                        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
                        for (PmsBaseAttrValue attrValue : attrValueList) {
                            Integer valueId = attrValue.getId();
                            if ( del.equals( Integer.toString(valueId))){
                                pmsSearchCrumb.setValueName(attrValue.getValueName());
                                iterator.remove();
                            }
                        }
                     }
                    pmsSearchCrumbs.add(pmsSearchCrumb);
                }

                map.put("attrValueSelectedList",pmsSearchCrumbs);
        }
            map.put("attrInfoList",attrInfoList);
    }

        String urlParam = getUrlParam(params);
        map.put("urlParam",urlParam);

        map.put("keyword",params.getKeyWord());


        return "list";
    }

    public String getUrlParamForCrumb(PmsSearchParams params,String delValueId ){

        Integer catalog2Id = params.getCatalog2Id();
        String keyWord = params.getKeyWord();
        String[] valueIds = params.getValueId();
        String urlParam ="";

        if (catalog2Id !=null){
            if (StringUtils.isNotBlank(urlParam)){
                urlParam+="&";
            }
            urlParam = urlParam+"catalog2Id="+catalog2Id ;
        }

        if (StringUtils.isNotBlank(keyWord)){
            if (StringUtils.isNotBlank(urlParam)){
                urlParam+="&";
            }
            urlParam = urlParam+"keyWord="+keyWord ;
        }

        if (valueIds !=null){
            for (String valueId : valueIds) {
                if ( !valueId .equals(delValueId)){
                    urlParam = urlParam+"&valueId="+Integer.parseInt(valueId);
                }
            }
        }

//        System.out.println(urlParam);

        return urlParam ;
    }

    public String getUrlParam(PmsSearchParams params ){

        Integer catalog2Id = params.getCatalog2Id();
        String keyWord = params.getKeyWord();
        String[] valueIds = params.getValueId();
        String urlParam ="";

        if (catalog2Id !=null){
            if (StringUtils.isNotBlank(urlParam)){
                urlParam+="&";
            }
            urlParam = urlParam+"catalog2Id="+catalog2Id ;
        }

        if (StringUtils.isNotBlank(keyWord)){
            if (StringUtils.isNotBlank(urlParam)){
                urlParam+="&";
            }
            urlParam = urlParam+"keyWord="+keyWord ;
        }

        if (valueIds !=null){
            for (String valueId : valueIds) {
                if ( valueId !=null){
                    urlParam = urlParam+"&valueId="+Integer.parseInt(valueId);
                }
            }
        }

//        System.out.println(urlParam);

        return urlParam ;
    }

    @RequestMapping("index")
    public String  index(ModelMap modelMap){
        List<PmsBaseCatalog1> catalog1s = catalogInfoService.getCatalog1();
        modelMap.put("catalog1s",catalog1s);
        return "index";
    }
}