package com.fwzx.photovoltaicdatacollect.pojo;

import java.util.Date;

public class PhotoActData {
    private String id;

    private Date getTime;

    private Double instRadiation;

    private Double windS;

    private Double windD;

    private Double tem;

    private Double humi;

    private Double press;

    private Double prePower;

    private Double actPower;

    private Date entryTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public Double getInstRadiation() {
        return instRadiation;
    }

    public void setInstRadiation(Double instRadiation) {
        this.instRadiation = instRadiation;
    }

    public Double getWindS() {
        return windS;
    }

    public void setWindS(Double windS) {
        this.windS = windS;
    }

    public Double getWindD() {
        return windD;
    }

    public void setWindD(Double windD) {
        this.windD = windD;
    }

    public Double getTem() {
        return tem;
    }

    public void setTem(Double tem) {
        this.tem = tem;
    }

    public Double getHumi() {
        return humi;
    }

    public void setHumi(Double humi) {
        this.humi = humi;
    }

    public Double getPress() {
        return press;
    }

    public void setPress(Double press) {
        this.press = press;
    }

    public Double getPrePower() {
        return prePower;
    }

    public void setPrePower(Double prePower) {
        this.prePower = prePower;
    }

    public Double getActPower() {
        return actPower;
    }

    public void setActPower(Double actPower) {
        this.actPower = actPower;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
}