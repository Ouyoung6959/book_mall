package com.hnit.bmall.bean;

import javax.persistence.Id;
import java.io.Serializable;

public class UmsMemberAddress implements Serializable {

    @Id
    private Integer id;

    private Integer memberId;

    private String name;

    private Integer phoneNumber;

    private String postCode;

    private String province;

    private String city;

    private String region;

    private String defaultAddr;

    public UmsMemberAddress(Integer id, Integer memberId, String name, Integer phoneNumber, String postCode, String province, String city, String region, String defaultAddr) {
        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.postCode = postCode;
        this.province = province;
        this.city = city;
        this.region = region;
        this.defaultAddr = defaultAddr;
    }

    public UmsMemberAddress() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getDefaultAddr() {
        return defaultAddr;
    }

    public void setDefaultAddr(String defaultAddr) {
        this.defaultAddr = defaultAddr == null ? null : defaultAddr.trim();
    }
}