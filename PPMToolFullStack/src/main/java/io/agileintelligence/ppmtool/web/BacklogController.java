package io.agileintelligence.ppmtool.web;

import io.agileintelligence.ppmtool.domain.ProjectTask;
import io.agileintelligence.ppmtool.services.MapValidationErrorService;
import io.agileintelligence.ppmtool.services.ProjectTaskService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qian
 * @create 2022-01-236:31 下午
 */
@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class BacklogController {

  @Autowired
  private ProjectTaskService projectTaskService;

  @Autowired
  private MapValidationErrorService mapValidationErrorService;

  @PostMapping("/{backlog_id}")
  public ResponseEntity<?> addPTtoBacklog(@Valid @RequestBody ProjectTask projectTask,
      BindingResult result, @PathVariable String backlog_id) {
    ResponseEntity<?> errMap = mapValidationErrorService.MapValidationService(result);
    if (errMap != null) {
      return errMap;
    }
    ProjectTask projectTask1 = projectTaskService.addProjectTask(backlog_id, projectTask);
    return new ResponseEntity<ProjectTask>(projectTask1, HttpStatus.CREATED);
  }

  @GetMapping("/{backlog_id}")
  public Iterable<ProjectTask> getProjectBacklog(@PathVariable String backlog_id){

    return projectTaskService.findBacklogById(backlog_id);

  }

}
