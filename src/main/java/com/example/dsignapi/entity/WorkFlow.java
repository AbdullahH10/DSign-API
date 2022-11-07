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
@Table(name = "work_flow_tbl")
public class WorkFlow {
    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        wid = wid;
    }

    public String getDocumentLocation() {
        return documentLocation;
    }

    public void setDocumentLocation(String documentLocation) {
        this.documentLocation = documentLocation;
    }

    public String getWorkflowName() {
        return workFlowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workFlowName = workflowName;
    }

    @Id
    @GeneratedValue
    private int wid;
    private String documentLocation;
    private String workFlowName;


}
