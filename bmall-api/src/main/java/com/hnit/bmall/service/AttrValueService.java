package com.hnit.bmall.service;

import com.hnit.bmall.bean.PmsBaseAttrInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Ouyoung
 * @date 2020/5/12
 **/
public interface AttrValueService {
    List<Map<String, Object>> getAttrInfo(Integer bid);

    List<PmsBaseAttrInfo> getAttrValueListByValueId(Set<Integer> valueSet);

    String getValueNameByValueId(String valueId);
}
