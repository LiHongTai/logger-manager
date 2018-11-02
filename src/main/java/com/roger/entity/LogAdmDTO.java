package com.roger.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogAdmDTO {

    private Long id;
    private String userId;
    private String userName;
    private String admMode;//模块
    private String admEvent;//操作
    private LocalDateTime dateCreated;//操作日期
    private String admOptContent;//操作内容
    private String desc;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdmMode() {
        return admMode;
    }

    public void setAdmMode(String admMode) {
        this.admMode = admMode;
    }

    public String getAdmEvent() {
        return admEvent;
    }

    public void setAdmEvent(String admEvent) {
        this.admEvent = admEvent;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAdmOptContent() {
        return admOptContent;
    }

    public void setAdmOptContent(String admOptContent) {
        this.admOptContent = admOptContent;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
