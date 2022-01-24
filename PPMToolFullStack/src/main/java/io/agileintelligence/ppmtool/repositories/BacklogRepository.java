package io.agileintelligence.ppmtool.repositories;

import io.agileintelligence.ppmtool.domain.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Qian
 * @create 2022-01-234:44 下午
 */
@Repository
public interface BacklogRepository extends CrudRepository<Backlog,Long> {

  Backlog findByProjectIdentifier(String Identifier);

}
