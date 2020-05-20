package com.hnit.bmall.book.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.hnit.bmall.bean.PmsBaseAttrInfo;
import com.hnit.bmall.bean.PmsBaseAttrValue;
import com.hnit.bmall.bean.PmsBookAttrValue;
import com.hnit.bmall.bean.PmsBookInfo;
import com.hnit.bmall.book.mapper.PmsBaseAttrInfoMapper;
import com.hnit.bmall.book.mapper.PmsBaseAttrValueMapper;
import com.hnit.bmall.book.mapper.PmsBookAttrValueMapper;
import com.hnit.bmall.book.mapper.PmsBookInfoMapper;
import com.hnit.bmall.service.AttrValueService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author Ouyoung
 * @date 2020/5/12
 **/
@Service
public class AttrValueServiceImpl implements AttrValueService {
    @Autowired
    PmsBookAttrValueMapper pmsBookAttrValueMapper ;
    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<Map<String, Object>> getAttrInfo(Integer bid) {
        PmsBookAttrValue pmsBookAttrValue= new PmsBookAttrValue();
        pmsBookAttrValue.setBid(bid);
        List<PmsBookAttrValue> pmsBookAttrValues = pmsBookAttrValueMapper.select(pmsBookAttrValue);
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        for (PmsBookAttrValue pmsBook :pmsBookAttrValues){
            HashMap<String, Object> map = new HashMap<>();
            Integer attrId = pmsBook.getAttrId();
            Integer valueId = pmsBook.getValueId();
            PmsBaseAttrInfo attrInfo = pmsBaseAttrInfoMapper.selectByPrimaryKey(attrId);
            String attrName = attrInfo.getAttrName();
            PmsBaseAttrValue attrValue = pmsBaseAttrValueMapper.selectByPrimaryKey(valueId);
            String valueName = attrValue.getValueName();
            map.put("attrName",attrName);
            map.put("valueName",valueName);
            maps.add(map);
        }
      return maps ;
    }

    @Override
    public List<PmsBaseAttrInfo> getAttrValueListByValueId(Set<Integer> valueSet) {
        String valueIdStr = StringUtils.join(valueSet, ",");
        List<PmsBaseAttrInfo> attrInfos = pmsBaseAttrInfoMapper.selectAttrValueListByValueId(valueIdStr);
        for (Integer integer : valueSet) {
            for (PmsBaseAttrInfo attrInfo : attrInfos) {

            }
        }
        return  attrInfos;
    }

    @Override
    public String getValueNameByValueId(String valueId) {
        PmsBaseAttrValue attrValue = pmsBaseAttrValueMapper.selectByPrimaryKey(Integer.parseInt(valueId));
        return attrValue.getValueName();
    }
}
