package com.fwzx.photovoltaicdatacollect.pojo;

import java.util.Date;

public class WindActSData {
    private String id;

    private Date getTime;

    private Double angle;

    private Double voltage1;

    private Double voltage2;

    private Double voltage3;

    private Double current1;

    private Double current2;

    private Double current3;

    private Double tempe;

    private Double wind;

    private Double direction;

    private Double power;

    private Double nopower;

    private Double windspeed;

    private Double motorspeed;

    private Double frequency;

    private Double electric;

    private Double factor;

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

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Double getVoltage1() {
        return voltage1;
    }

    public void setVoltage1(Double voltage1) {
        this.voltage1 = voltage1;
    }

    public Double getVoltage2() {
        return voltage2;
    }

    public void setVoltage2(Double voltage2) {
        this.voltage2 = voltage2;
    }

    public Double getVoltage3() {
        return voltage3;
    }

    public void setVoltage3(Double voltage3) {
        this.voltage3 = voltage3;
    }

    public Double getCurrent1() {
        return current1;
    }

    public void setCurrent1(Double current1) {
        this.current1 = current1;
    }

    public Double getCurrent2() {
        return current2;
    }

    public void setCurrent2(Double current2) {
        this.current2 = current2;
    }

    public Double getCurrent3() {
        return current3;
    }

    public void setCurrent3(Double current3) {
        this.current3 = current3;
    }

    public Double getTempe() {
        return tempe;
    }

    public void setTempe(Double tempe) {
        this.tempe = tempe;
    }

    public Double getWind() {
        return wind;
    }

    public void setWind(Double wind) {
        this.wind = wind;
    }

    public Double getDirection() {
        return direction;
    }

    public void setDirection(Double direction) {
        this.direction = direction;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getNopower() {
        return nopower;
    }

    public void setNopower(Double nopower) {
        this.nopower = nopower;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }

    public Double getMotorspeed() {
        return motorspeed;
    }

    public void setMotorspeed(Double motorspeed) {
        this.motorspeed = motorspeed;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public Double getElectric() {
        return electric;
    }

    public void setElectric(Double electric) {
        this.electric = electric;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }
}