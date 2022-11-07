package com.example.dsignapi.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "FILE_DATA_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Wid;

    public int getWid() {
        return Wid;
    }

    public void setWid(int wid) {
        Wid = wid;
    }

    public String getDocumentLocation() {
        return documentLocation;
    }

    public void setDocumentLocation(String documentLocation) {
        this.documentLocation = documentLocation;
    }

    public String getWorkFlowName() {
        return workFlowName;
    }

    public void setWorkFlowName(String workFlowName) {
        this.workFlowName = workFlowName;
    }

    private String documentLocation;
    private String workFlowName;

    public String getFilePath() {
        return documentLocation;
    }
}
