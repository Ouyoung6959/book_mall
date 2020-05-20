package com.hnit.bmall.bean;

import java.util.List;

/**
 * @author Ouyoung
 * @date 2020/5/1
 **/
public class RequestManalData {
    private Integer id ;
    private String attrName ;
    private Integer catalog2 ;
    private List<PmsBaseAttrValue>  pmsBaseAttrValues;

    public RequestManalData(Integer id, String attrName, Integer catalog2, List<PmsBaseAttrValue> pmsBaseAttrValues) {
        this.id = id;
        this.attrName = attrName;
        this.catalog2 = catalog2;
        this.pmsBaseAttrValues = pmsBaseAttrValues;
    }

    public RequestManalData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Integer getCatalog2() {
        return catalog2;
    }

    public void setCatalog2(Integer catalog2) {
        this.catalog2 = catalog2;
    }

    public List<PmsBaseAttrValue> getPmsBaseAttrValues() {
        return pmsBaseAttrValues;
    }

    public void setPmsBaseAttrValues(List<PmsBaseAttrValue> pmsBaseAttrValues) {
        this.pmsBaseAttrValues = pmsBaseAttrValues;
    }

    @Override
    public String toString() {
        return "RequestManalData{" +
                "id=" + id +
                ", attrName='" + attrName + '\'' +
                ", catalog2=" + catalog2 +
                ", pmsBaseAttrValues=" + pmsBaseAttrValues +
                '}';
    }
}
