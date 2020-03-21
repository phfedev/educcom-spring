package br.com.phfedev.educcom.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.phfedev.educcom.models.Course;

@RepositoryRestResource(collectionResourceRel = "course", path = "course")
public interface CourseRepository extends PagingAndSortingRepository<Course, Integer>{
	List<Course> findByName(@Param("name") String name);
}
