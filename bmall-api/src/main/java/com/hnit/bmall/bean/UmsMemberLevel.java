package com.hnit.bmall.bean;

import javax.persistence.Id;
import java.io.Serializable;

public class UmsMemberLevel  implements Serializable {

    @Id
    private Integer id;

    private String levelName;

    private String growthPoint;

    public UmsMemberLevel(Integer id, String levelName, String growthPoint) {
        this.id = id;
        this.levelName = levelName;
        this.growthPoint = growthPoint;
    }

    public UmsMemberLevel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public String getGrowthPoint() {
        return growthPoint;
    }

    public void setGrowthPoint(String growthPoint) {
        this.growthPoint = growthPoint == null ? null : growthPoint.trim();
    }
}