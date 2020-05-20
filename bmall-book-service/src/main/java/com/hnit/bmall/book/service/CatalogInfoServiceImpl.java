package com.hnit.bmall.book.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.hnit.bmall.bean.*;
import com.hnit.bmall.book.mapper.*;
import com.hnit.bmall.service.CatalogInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ouyoung
 * @date 2020/5/1
 **/
@Service
public class CatalogInfoServiceImpl implements CatalogInfoService {

    @Autowired
    PmsBaseCatalog1Mapper catalog1Mapper ;

    @Autowired
    PmsBaseCatalog2Mapper catalog2Mapper ;

    @Autowired
    PmsBaseAttrInfoMapper attrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper attrValueMapper;

    @Autowired
    PmsBookInfoMapper pmsBookInfoMapper;


    public List<PmsBaseCatalog1> getCatalog1(){

        List<PmsBaseCatalog1> pmsBaseCatalog1s = catalog1Mapper.selectAll();
        return pmsBaseCatalog1s;

    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(Integer id) {
        PmsBaseCatalog2 catalog2 = new PmsBaseCatalog2();
        catalog2.setCatalog1Id(id);
        List<PmsBaseCatalog2> catalog2s = catalog2Mapper.select(catalog2);
        return catalog2s;
    }

    @Override
    public List<PmsBaseAttrInfo> getAttrInfoList(Integer id) {
        PmsBaseAttrInfo attrInfo = new PmsBaseAttrInfo();
        attrInfo.setCatalog2Id(id);

        List<PmsBaseAttrInfo> attrInfos = attrInfoMapper.select(attrInfo);

        return attrInfos;
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(Integer attrId) {
        PmsBaseAttrValue attrValue = new PmsBaseAttrValue();
        attrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> attrValues = attrValueMapper.select(attrValue);
        return attrValues;
    }

    @Override
    public void updateOrAddPmsBaseAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
       if(pmsBaseAttrInfo.getId() !=null && !pmsBaseAttrInfo.getId().equals("")){
           int i = attrInfoMapper.updateByPrimaryKey(pmsBaseAttrInfo);
           for (PmsBaseAttrValue attrValue :pmsBaseAttrInfo.getAttrValueList()){
               if (attrValue.getAttrId() !=null && !attrValue.getAttrId().equals("")){
                   attrValueMapper.updateByPrimaryKey(attrValue);
               }else {
                   attrValue.setAttrId(pmsBaseAttrInfo.getId());
                   attrValueMapper.insert(attrValue);
               }
           }

       }else{
           attrInfoMapper.insert(pmsBaseAttrInfo);
           Integer attrId = pmsBaseAttrInfo.getId();
           for (PmsBaseAttrValue attrValue :pmsBaseAttrInfo.getAttrValueList()) {
               attrValue.setAttrId(attrId);
               attrValueMapper.insert(attrValue);
           }
       }
   }

    @Override
    public void removeAttrValueById(Integer attrValueId) {
        PmsBaseAttrValue attrValue = new PmsBaseAttrValue();
        attrValue.setId(attrValueId);
        attrValueMapper.delete(attrValue);

        List<PmsBaseAttrValue> attrValues = attrValueMapper.selectAll();
        System.out.println(attrValues);
    }

    @Override
    public Map<String, Object> getCatalogs(Integer bid) {

        PmsBookInfo pmsBookInfo = pmsBookInfoMapper.selectByPrimaryKey(bid);
        HashMap<String, Object> map = new HashMap<>();
        Integer catalog2Id = pmsBookInfo.getCatalog2Id();
        PmsBaseCatalog2 pmsBaseCatalog2 = catalog2Mapper.selectByPrimaryKey(catalog2Id);
        String catalog2Name = pmsBaseCatalog2.getName();
        map.put("catalog2Name",catalog2Name);
        Integer catalog1Id = pmsBaseCatalog2.getCatalog1Id();
        PmsBaseCatalog1 pmsBaseCatalog1 = catalog1Mapper.selectByPrimaryKey(catalog1Id);
        String catalog1Name = pmsBaseCatalog1.getName();
        map.put("catalog1Name",catalog1Name);
        return  map;
    }

    @Override
    public List<PmsBaseCatalog1> getCatalog() {
        List<PmsBaseCatalog1> catalogs = catalog1Mapper.getCatalogs();
        return catalogs ;
    }


}
