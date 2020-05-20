package com.hnit.bmall.bean;

public class PmsBookAssociate {
    private Integer id;

    private Integer bid;

    private Integer associatedId;

    public PmsBookAssociate() {
    }

    public PmsBookAssociate(Integer id, Integer bid, Integer associatedId) {
        this.id = id;
        this.bid = bid;
        this.associatedId = associatedId;
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

    public Integer getAssociatedId() {
        return associatedId;
    }

    public void setAssociatedId(Integer associatedId) {
        this.associatedId = associatedId;
    }
}