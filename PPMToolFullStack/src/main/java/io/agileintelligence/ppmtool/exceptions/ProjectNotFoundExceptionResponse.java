package io.agileintelligence.ppmtool.exceptions;

/**
 * @author Qian
 * @create 2022-01-237:16 下午
 */
public class ProjectNotFoundExceptionResponse {

  private String ProjectNotFound;

  public ProjectNotFoundExceptionResponse(String projectNotFound) {
    ProjectNotFound = projectNotFound;
  }

  public String getProjectNotFound() {
    return ProjectNotFound;
  }

  public void setProjectNotFound(String projectNotFound) {
    ProjectNotFound = projectNotFound;
  }

}
