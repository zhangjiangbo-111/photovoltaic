package com.fwzx.photovoltaicdatacollect.pojo;

import java.util.Date;

public class PowerDuanqi {
    private String id;

    private String staname;

    private Date datetime;

    private Integer shici;

    private Double tem;

    private Double humi;

    private Double winds;

    private Double windd;

    private Double pre;

    private String wea;

    private String thour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStaname() {
        return staname;
    }

    public void setStaname(String staname) {
        this.staname = staname == null ? null : staname.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getShici() {
        return shici;
    }

    public void setShici(Integer shici) {
        this.shici = shici;
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

    public Double getWinds() {
        return winds;
    }

    public void setWinds(Double winds) {
        this.winds = winds;
    }

    public Double getWindd() {
        return windd;
    }

    public void setWindd(Double windd) {
        this.windd = windd;
    }

    public Double getPre() {
        return pre;
    }

    public void setPre(Double pre) {
        this.pre = pre;
    }

    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea == null ? null : wea.trim();
    }

    public String getThour() {
        return thour;
    }

    public void setThour(String thour) {
        this.thour = thour;
    }
}