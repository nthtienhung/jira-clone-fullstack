package org.k3personal.jiraclone.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
public class Project {
    //test
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is how the id is auto gen
    private Long id;
    @NotBlank(message = "project name is required")
    private String projectName;
    @NotBlank(message = "project identifier is required")
    @Size(min = 4, max = 5, message= "please 4 to 5 characters")
    @Column(updatable= false, unique = true)
    private String projectIdentifier;
    @NotBlank(message="description is required")
    private String projectDescription;
    @JsonFormat(pattern="dd-mm-yyyy")
    private Date startDate;
    @JsonFormat(pattern="dd-mm-yyyy")
    private Date endDate;
    @JsonFormat(pattern="dd-mm-yyyy")
    private Date created_At;
    @JsonFormat(pattern="dd-mm-yyyy")
    private Date updated_At;

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }
    //what is the point of noargconstructor?
    protected Project() {

    }
}
