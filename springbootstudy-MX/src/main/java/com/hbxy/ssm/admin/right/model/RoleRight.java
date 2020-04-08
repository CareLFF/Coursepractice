package com.hbxy.ssm.admin.right.model;

import java.io.Serializable;

/**
 * mx_role_right
 * @author 
 */
public class RoleRight implements Serializable {
    private String roleRightId;

    private String resourceId;

    private String roleId;

    private static final long serialVersionUID = 1L;

    public String getRoleRightId() {
        return roleRightId;
    }

    public void setRoleRightId(String roleRightId) {
        this.roleRightId = roleRightId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
        RoleRight other = (RoleRight) that;
        return (this.getRoleRightId() == null ? other.getRoleRightId() == null : this.getRoleRightId().equals(other.getRoleRightId()))
            && (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId().equals(other.getResourceId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleRightId() == null) ? 0 : getRoleRightId().hashCode());
        result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleRightId=").append(roleRightId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}