package com.hnit.bmall.service;

import com.hnit.bmall.bean.PmsBaseAttrInfo;
import com.hnit.bmall.bean.PmsBaseAttrValue;
import com.hnit.bmall.bean.PmsBaseCatalog1;
import com.hnit.bmall.bean.PmsBaseCatalog2;

import java.util.List;
import java.util.Map;

/**
 * @author Ouyoung
 * @date 2020/5/1
 **/
public interface CatalogInfoService {

    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(Integer id) ;


    List<PmsBaseAttrInfo>  getAttrInfoList(Integer id);

    List<PmsBaseAttrValue> getAttrValueList(Integer attrId);

    void updateOrAddPmsBaseAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    void removeAttrValueById(Integer attrValueId);

    Map<String,Object> getCatalogs(Integer bid);

    List<PmsBaseCatalog1> getCatalog();
}
