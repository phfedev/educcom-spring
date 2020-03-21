package br.com.phfedev.educcom.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.phfedev.educcom.models.Lesson;

@RepositoryRestResource(collectionResourceRel = "lesson", path = "lesson")
public interface LessonRepository extends PagingAndSortingRepository<Lesson, Integer> {
	List<Lesson> findByName(@Param("name") String name);
}
