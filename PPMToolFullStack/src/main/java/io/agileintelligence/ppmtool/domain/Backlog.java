package io.agileintelligence.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Qian
 * @create 2022-01-234:30 下午
 */
@Entity
public class Backlog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer PTSequence = 0;
  private String projectIdentifier;
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="project_id",nullable = false)
  @JsonIgnore
  private Project project;

  public Backlog() {
  }

  public Backlog(Long id, Integer PTSequence, String projectIdentifier) {
    this.id = id;
    this.PTSequence = PTSequence;
    this.projectIdentifier = projectIdentifier;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getPTSequence() {
    return PTSequence;
  }

  public void setPTSequence(Integer PTSequence) {
    this.PTSequence = PTSequence;
  }

  public String getProjectIdentifier() {
    return projectIdentifier;
  }

  public void setProjectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

}
