package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.Backlog;
import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.domain.ProjectTask;
import io.agileintelligence.ppmtool.exceptions.ProjectNotFoundException;
import io.agileintelligence.ppmtool.repositories.BacklogRepository;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;
import io.agileintelligence.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qian
 * @create 2022-01-236:16 下午
 */
@Service
public class ProjectTaskService {

  @Autowired
  private BacklogRepository backlogRepository;

  @Autowired
  private ProjectTaskRepository projectTaskRepository;

  @Autowired
  private ProjectRepository projectRepository;

  public ProjectTask addProjectTask(String projectIdentifier,ProjectTask projectTask){

    try {
      Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
      projectTask.setBacklog(backlog);
      Integer backlogSequence = backlog.getPTSequence();
      backlogSequence++;
      backlog.setPTSequence(backlogSequence);
      projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
      projectTask.setProjectIdentifer(projectIdentifier);

      if (projectTask.getPriority() == 0 || projectTask.getPriority() == null) {
        projectTask.setPriority(3);
      }

      if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
        projectTask.setStatus("To_Do");
      }

      return projectTaskRepository.save(projectTask);
    } catch (Exception e) {
      throw new ProjectNotFoundException("project not found");
    }


  }


  public Iterable<ProjectTask>findBacklogById(String id){
    Project project = projectRepository.findByProjectIdentifier(id);

    if(project==null){
      throw new ProjectNotFoundException("Project with ID: '"+id+"' does not exist");
    }

    return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
  }
}
