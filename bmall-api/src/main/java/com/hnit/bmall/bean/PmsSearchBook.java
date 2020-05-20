package com.hnit.bmall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ouyoung
 * @date 2020/5/15
 **/
public class PmsSearchBook implements Serializable {
    private Integer bid;

    private String title;

    private String price;

    private String imageUrl;

    private Integer catalog2Id;

    private String description;

    private double hotScore;
    private List<PmsBookAttrValue> pmsBookAttrValues;

    public List<PmsBookAttrValue> getPmsBookAttrValues() {
        return pmsBookAttrValues;
    }

    public void setPmsBookAttrValues(List<PmsBookAttrValue> pmsBookAttrValues) {
        this.pmsBookAttrValues = pmsBookAttrValues;
    }

    public PmsSearchBook() {
    }

    public PmsSearchBook(Integer bid, String title, String description, Integer catalog2Id, String price, String imageUrl, double hotScore, List<com.hnit.bmall.bean.PmsBookAttrValue> pmsBookAttrValues) {
        this.bid = bid;
        this.title = title;
        this.description = description;
        this.catalog2Id = catalog2Id;
        this.price = price;
        this.imageUrl = imageUrl;
        this.hotScore = hotScore;
        pmsBookAttrValues = pmsBookAttrValues;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(Integer catalog2Id) {
        this.catalog2Id = catalog2Id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getHotScore() {
        return hotScore;
    }

    public void setHotScore(double hotScore) {
        this.hotScore = hotScore;
    }



}
