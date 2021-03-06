package com.xuebusi.xssm.pattern.observer.active.job.dto;

import java.io.Serializable;

/**
 * 活动Dto
 */
public class ActiveDto implements Serializable {

    /**
     * 活动编码
     */
    private String activeCode;

    /**
     * 活动名称
     */
    private String activeName;

    /**
     * 活动状态
     */
    private String activeStatus;

    /**
     * 活动开始时间
     */
    private String activeStartTime;

    /**
     * 活动结束时间
     */
    private String activeEndTime;

    public ActiveDto() {
    }

    public ActiveDto(String activeCode, String activeName, String activeStatus) {
        this.activeCode = activeCode;
        this.activeName = activeName;
        this.activeStatus = activeStatus;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getActiveStartTime() {
        return activeStartTime;
    }

    public void setActiveStartTime(String activeStartTime) {
        this.activeStartTime = activeStartTime;
    }

    public String getActiveEndTime() {
        return activeEndTime;
    }

    public void setActiveEndTime(String activeEndTime) {
        this.activeEndTime = activeEndTime;
    }
}
