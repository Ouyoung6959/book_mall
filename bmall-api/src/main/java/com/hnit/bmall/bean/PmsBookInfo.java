package com.hnit.bmall.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public class PmsBookInfo  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;

    private String title;

    private String price;

    private String imageUrl;

    private String pubilshTime;

    private Integer catalog2Id;

    private String description;

    @Transient
    List<PmsBookAttrValue> pmsBookAttrValues;

    public List<PmsBookAttrValue> getPmsBookAttrValues() {
        return pmsBookAttrValues;
    }

    public void setPmsBookAttrValues(List<PmsBookAttrValue> pmsBookAttrValues) {
        this.pmsBookAttrValues = pmsBookAttrValues;
    }

    public PmsBookInfo() {
    }

    public PmsBookInfo(Integer bid, String title, String price, String imageUrl, String pubilshTime, Integer catalog2Id, String description) {
        this.bid = bid;
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
        this.pubilshTime = pubilshTime;
        this.catalog2Id = catalog2Id;
        this.description = description;
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

    public String getPubilshTime() {
        return pubilshTime;
    }

    public void setPubilshTime(String pubilshTime) {
        this.pubilshTime = pubilshTime;
    }

    public Integer getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(Integer catalog2Id) {
        this.catalog2Id = catalog2Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PmsBookInfo{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", pubilshTime='" + pubilshTime + '\'' +
                ", catalog2Id=" + catalog2Id +
                ", description='" + description + '\'' +
                '}';
    }
}