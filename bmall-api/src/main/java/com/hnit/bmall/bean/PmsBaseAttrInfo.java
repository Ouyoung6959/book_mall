package com.hnit.bmall.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public class PmsBaseAttrInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String attrName;

    private Integer catalog2Id;

    private String isEnable;

    @Transient
    List<PmsBaseAttrValue> attrValueList;

    @Transient
    List<PmsBookAttrValue> pmsBookAttrValue;

    public List<PmsBookAttrValue> getPmsBookAttrValue() {
        return pmsBookAttrValue;
    }

    public void setPmsBookAttrValue(List<PmsBookAttrValue> pmsBookAttrValue) {
        this.pmsBookAttrValue = pmsBookAttrValue;
    }

    public List<PmsBaseAttrValue> getAttrValueList() {
        return attrValueList;
    }

    public PmsBaseAttrInfo(String attrName, Integer catalog2Id, String isEnable, List<PmsBaseAttrValue> attrValueList, List<PmsBookAttrValue> pmsBookAttrValue) {
        this.attrName = attrName;
        this.catalog2Id = catalog2Id;
        this.isEnable = isEnable;
        this.attrValueList = attrValueList;
        this.pmsBookAttrValue = pmsBookAttrValue;
    }

    public void setAttrValueList(List<PmsBaseAttrValue> attrValueList) {
        this.attrValueList = attrValueList;
    }

    public PmsBaseAttrInfo() {
        super();
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
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public Integer getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(Integer catalog2Id) {
        this.catalog2Id = catalog2Id;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    @Override
    public String toString() {
        return "PmsBaseAttrInfo{" +
                "id=" + id +
                ", attrName='" + attrName + '\'' +
                ", catalog2Id=" + catalog2Id +
                ", isEnable='" + isEnable + '\'' +
                ", attrValueList=" + attrValueList +
                '}';
    }
}