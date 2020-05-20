package com.hnit.bmall.bean;

import javax.persistence.Id;
import java.io.Serializable;

public class PmsBookAttrValue implements Serializable {
    @Id
    private Integer id;

    private Integer bid;

    private Integer attrId;

    private Integer valueId;

    public PmsBookAttrValue(Integer id, Integer bid, Integer attrId, Integer valueId) {
        this.id = id;
        this.bid = bid;
        this.attrId = attrId;
        this.valueId = valueId;
    }

    public PmsBookAttrValue() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    @Override
    public String toString() {
        return "PmsBookAttrValue{" +
                "id=" + id +
                ", bid=" + bid +
                ", attrId=" + attrId +
                ", valueId=" + valueId +
                '}';
    }
}