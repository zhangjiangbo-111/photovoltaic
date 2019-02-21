package com.fwzx.photovoltaicdatacollect.pojo;

import java.util.Date;

public class TblYujingContent {
    private String id;

    private Date publishDate;

    private String yujingType;

    private String yujingLevel;

    private String yujingContent;

    private Date yujingDate;

    private String sign;

    private String publishLocation;

    private String flag;

    private String publishPerson;

    private Date removeTime;

    private String removeContent;

    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getYujingType() {
        return yujingType;
    }

    public void setYujingType(String yujingType) {
        this.yujingType = yujingType == null ? null : yujingType.trim();
    }

    public String getYujingLevel() {
        return yujingLevel;
    }

    public void setYujingLevel(String yujingLevel) {
        this.yujingLevel = yujingLevel == null ? null : yujingLevel.trim();
    }

    public String getYujingContent() {
        return yujingContent;
    }

    public void setYujingContent(String yujingContent) {
        this.yujingContent = yujingContent == null ? null : yujingContent.trim();
    }

    public Date getYujingDate() {
        return yujingDate;
    }

    public void setYujingDate(Date yujingDate) {
        this.yujingDate = yujingDate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getPublishLocation() {
        return publishLocation;
    }

    public void setPublishLocation(String publishLocation) {
        this.publishLocation = publishLocation == null ? null : publishLocation.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getPublishPerson() {
        return publishPerson;
    }

    public void setPublishPerson(String publishPerson) {
        this.publishPerson = publishPerson == null ? null : publishPerson.trim();
    }

    public Date getRemoveTime() {
        return removeTime;
    }

    public void setRemoveTime(Date removeTime) {
        this.removeTime = removeTime;
    }

    public String getRemoveContent() {
        return removeContent;
    }

    public void setRemoveContent(String removeContent) {
        this.removeContent = removeContent == null ? null : removeContent.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}