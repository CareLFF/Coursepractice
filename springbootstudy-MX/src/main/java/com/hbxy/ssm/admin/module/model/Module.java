package com.hbxy.ssm.admin.module.model;

import java.io.Serializable;
import java.util.Date;

/**
 * mx_module
 * @author 
 */
public class Module implements Serializable {
    private String moduleId;

    private String appId;

    private String appName;

    private String moduleName;

    private String moduleCode;

    private String moduleIconUrl;

    private String moduleUrl;

    /**
     * 是否管理模块：0-否；1-是
     */
    private String isAdmin;

    /**
     * 是否需要权限：0-否；1-是
     */
    private String needRight;

    private Integer orderIndex;

    private String comments;

    /**
     * 0-正常；1-禁用
     */
    private String currentStatus;

    private Date createdTime;

    private String createdUserLoginId;

    private Date lastUpdatedTime;

    private String lastUpdatedUserLoginId;

    private static final long serialVersionUID = 1L;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleIconUrl() {
        return moduleIconUrl;
    }

    public void setModuleIconUrl(String moduleIconUrl) {
        this.moduleIconUrl = moduleIconUrl;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getNeedRight() {
        return needRight;
    }

    public void setNeedRight(String needRight) {
        this.needRight = needRight;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedUserLoginId() {
        return createdUserLoginId;
    }

    public void setCreatedUserLoginId(String createdUserLoginId) {
        this.createdUserLoginId = createdUserLoginId;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getLastUpdatedUserLoginId() {
        return lastUpdatedUserLoginId;
    }

    public void setLastUpdatedUserLoginId(String lastUpdatedUserLoginId) {
        this.lastUpdatedUserLoginId = lastUpdatedUserLoginId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Module other = (Module) that;
        return (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getModuleName() == null ? other.getModuleName() == null : this.getModuleName().equals(other.getModuleName()))
            && (this.getModuleCode() == null ? other.getModuleCode() == null : this.getModuleCode().equals(other.getModuleCode()))
            && (this.getModuleIconUrl() == null ? other.getModuleIconUrl() == null : this.getModuleIconUrl().equals(other.getModuleIconUrl()))
            && (this.getModuleUrl() == null ? other.getModuleUrl() == null : this.getModuleUrl().equals(other.getModuleUrl()))
            && (this.getIsAdmin() == null ? other.getIsAdmin() == null : this.getIsAdmin().equals(other.getIsAdmin()))
            && (this.getNeedRight() == null ? other.getNeedRight() == null : this.getNeedRight().equals(other.getNeedRight()))
            && (this.getOrderIndex() == null ? other.getOrderIndex() == null : this.getOrderIndex().equals(other.getOrderIndex()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getCurrentStatus() == null ? other.getCurrentStatus() == null : this.getCurrentStatus().equals(other.getCurrentStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatedUserLoginId() == null ? other.getCreatedUserLoginId() == null : this.getCreatedUserLoginId().equals(other.getCreatedUserLoginId()))
            && (this.getLastUpdatedTime() == null ? other.getLastUpdatedTime() == null : this.getLastUpdatedTime().equals(other.getLastUpdatedTime()))
            && (this.getLastUpdatedUserLoginId() == null ? other.getLastUpdatedUserLoginId() == null : this.getLastUpdatedUserLoginId().equals(other.getLastUpdatedUserLoginId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getModuleName() == null) ? 0 : getModuleName().hashCode());
        result = prime * result + ((getModuleCode() == null) ? 0 : getModuleCode().hashCode());
        result = prime * result + ((getModuleIconUrl() == null) ? 0 : getModuleIconUrl().hashCode());
        result = prime * result + ((getModuleUrl() == null) ? 0 : getModuleUrl().hashCode());
        result = prime * result + ((getIsAdmin() == null) ? 0 : getIsAdmin().hashCode());
        result = prime * result + ((getNeedRight() == null) ? 0 : getNeedRight().hashCode());
        result = prime * result + ((getOrderIndex() == null) ? 0 : getOrderIndex().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getCurrentStatus() == null) ? 0 : getCurrentStatus().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatedUserLoginId() == null) ? 0 : getCreatedUserLoginId().hashCode());
        result = prime * result + ((getLastUpdatedTime() == null) ? 0 : getLastUpdatedTime().hashCode());
        result = prime * result + ((getLastUpdatedUserLoginId() == null) ? 0 : getLastUpdatedUserLoginId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moduleId=").append(moduleId);
        sb.append(", appId=").append(appId);
        sb.append(", appName=").append(appName);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", moduleCode=").append(moduleCode);
        sb.append(", moduleIconUrl=").append(moduleIconUrl);
        sb.append(", moduleUrl=").append(moduleUrl);
        sb.append(", isAdmin=").append(isAdmin);
        sb.append(", needRight=").append(needRight);
        sb.append(", orderIndex=").append(orderIndex);
        sb.append(", comments=").append(comments);
        sb.append(", currentStatus=").append(currentStatus);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", createdUserLoginId=").append(createdUserLoginId);
        sb.append(", lastUpdatedTime=").append(lastUpdatedTime);
        sb.append(", lastUpdatedUserLoginId=").append(lastUpdatedUserLoginId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}