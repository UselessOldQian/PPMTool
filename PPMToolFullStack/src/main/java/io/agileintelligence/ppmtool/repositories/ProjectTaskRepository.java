package io.agileintelligence.ppmtool.repositories;

import io.agileintelligence.ppmtool.domain.ProjectTask;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Qian
 * @create 2022-01-234:45 下午
 */
@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

  List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);

}
