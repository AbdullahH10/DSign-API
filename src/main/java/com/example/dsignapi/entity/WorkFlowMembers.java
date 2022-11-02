package com.example.dsignapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="work_flow_members_tbl")
public class WorkFlowMembers {
    public int getWid() {
        return wfId;
    }

    public void setWid(int wid) {
        this.wfId = wid;
    }

    public int getUserid() {
        return userId;
    }

    public void setUserid(int userid) {
        userId = userid;
    }

    @Id
    @GeneratedValue
    private int wfId;

    private int userId;

}
