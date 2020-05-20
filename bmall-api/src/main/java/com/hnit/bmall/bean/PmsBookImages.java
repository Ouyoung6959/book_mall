package com.hnit.bmall.bean;

import javax.persistence.Id;
import java.io.Serializable;

public class PmsBookImages  implements Serializable {
    @Id
    private Integer id;

    private Integer bid;

    private String imageName;

    private String imageUrl;

    private String isDefault;

    public PmsBookImages(Integer id, Integer bid, String imageName, String imageUrl, String isDefault) {
        this.id = id;
        this.bid = bid;
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.isDefault = isDefault;
    }

    public PmsBookImages() {
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "PmsBookImages{" +
                "id=" + id +
                ", bid=" + bid +
                ", imageName='" + imageName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}