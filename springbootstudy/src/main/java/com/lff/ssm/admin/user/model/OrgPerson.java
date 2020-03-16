package com.lff.ssm.admin.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * 
 */
public class OrgPerson implements Serializable {
    private String orgPersonId;

    private String orgId;

    private String personId;

    private Date fromDate;

    private Date thruDate;

    private static final long serialVersionUID = 1L;

    public String getOrgPersonId() {
        return orgPersonId;
    }

    public void setOrgPersonId(String orgPersonId) {
        this.orgPersonId = orgPersonId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getThruDate() {
        return thruDate;
    }

    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }
}