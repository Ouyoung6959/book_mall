package com.hnit.bmall.bean;

import javax.persistence.Id;
import java.io.Serializable;

public class PmsBaseAttrValue implements Serializable {
    @Id
    private Integer id;

    private String valueName;

    private Integer attrId;

    private Integer isEnable;

    public PmsBaseAttrValue(Integer id, String valueName, Integer attrId, Integer isEnable) {
        this.id = id;
        this.valueName = valueName;
        this.attrId = attrId;
        this.isEnable = isEnable;
    }

    public PmsBaseAttrValue() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        return "PmsBaseAttrValue{" +
                "id=" + id +
                ", valueName='" + valueName + '\'' +
                ", attrId=" + attrId +
                ", isEnable=" + isEnable +
                '}';
    }
}