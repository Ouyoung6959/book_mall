package com.hnit.bmall.bean;

/**
 * @author Ouyoung
 * @date 2020/5/20
 **/
public class PmsSearchCrumb {
    private Integer valueId;
    private String valueName ;
    private String urlParam ;

    public PmsSearchCrumb(Integer valueId, String valueName, String urlParam) {
        this.valueId = valueId;
        this.valueName = valueName;
        this.urlParam = urlParam;
    }

    public PmsSearchCrumb() {
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(String urlParam) {
        this.urlParam = urlParam;
    }
}
