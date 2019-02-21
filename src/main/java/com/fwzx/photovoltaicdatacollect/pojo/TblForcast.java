package com.fwzx.photovoltaicdatacollect.pojo;

import java.util.Date;

public class TblForcast {
    private String id;

    private Date datetime;

    private Date entrytime;

    private String stationId;

    private Double temMax;

    private Double temMin;

    private String weather;

    private String windS;

    private Integer shici;

    private String thour;

    private String windD;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    public Double getTemMax() {
        return temMax;
    }

    public void setTemMax(Double temMax) {
        this.temMax = temMax;
    }

    public Double getTemMin() {
        return temMin;
    }

    public void setTemMin(Double temMin) {
        this.temMin = temMin;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public String getWindS() {
        return windS;
    }

    public void setWindS(String windS) {
        this.windS = windS == null ? null : windS.trim();
    }

    public Integer getShici() {
        return shici;
    }

    public void setShici(Integer shici) {
        this.shici = shici;
    }

    public String getThour() {
        return thour;
    }

    public void setThour(String thour) {
        this.thour = thour == null ? null : thour.trim();
    }

    public String getWindD() {
        return windD;
    }

    public void setWindD(String windD) {
        this.windD = windD == null ? null : windD.trim();
    }
}