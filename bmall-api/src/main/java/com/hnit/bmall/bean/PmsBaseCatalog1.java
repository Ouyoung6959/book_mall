package com.hnit.bmall.bean;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Component
public class PmsBaseCatalog1 implements Serializable {
    @Id
    private Integer id;

    private String name;

    @Transient
    private List<PmsBaseCatalog2> pmsBaseCatalog2s;

    @Transient
    public List<PmsBaseCatalog2> getPmsBaseCatalog2s() {
        return pmsBaseCatalog2s;
    }

    @Transient
    public void setPmsBaseCatalog2s(List<PmsBaseCatalog2> pmsBaseCatalog2s) {
        this.pmsBaseCatalog2s = pmsBaseCatalog2s;
    }

    public PmsBaseCatalog1(Integer id, String name, List<PmsBaseCatalog2> pmsBaseCatalog2s) {
        this.id = id;
        this.name = name;
        this.pmsBaseCatalog2s = pmsBaseCatalog2s;
    }

    public PmsBaseCatalog1() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}