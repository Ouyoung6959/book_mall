package com.hnit.bmall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ouyoung
 * @date 2020/5/18
 **/
public class PmsSearchParams implements Serializable {
    private Integer catalog2Id;
    private String keyWord;
    private String[] valueId;

    public PmsSearchParams() {
    }

    public PmsSearchParams(Integer catalog2Id, String keyWord, String[] valueId) {
        this.catalog2Id = catalog2Id;
        this.keyWord = keyWord;
        this.valueId = valueId;
    }

    public Integer getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(Integer catalog2Id) {
        this.catalog2Id = catalog2Id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String[] getValueId() {
        return valueId;
    }

    public void setValueId(String[] valueId) {
        this.valueId = valueId;
    }
}
