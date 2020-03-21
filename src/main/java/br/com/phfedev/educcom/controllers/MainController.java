package br.com.phfedev.educcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.phfedev.educcom.models.Course;
import br.com.phfedev.educcom.models.Lesson;
import br.com.phfedev.educcom.models.User;
import br.com.phfedev.educcom.repositories.CourseRepository;
import br.com.phfedev.educcom.repositories.LessonRepository;
import br.com.phfedev.educcom.repositories.UserRepository;

@Controller("/home")
//@RequestMapping(path = "/home")
public class MainController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private LessonRepository lessonRepository;

	@PostMapping(path = "/adduser")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@PostMapping(path = "/addcourse")
	public @ResponseBody String addNewCourse(@RequestParam String name, @RequestParam String description) {
		Course c = new Course();
		c.setName(name);
		c.setDescription(description);
		courseRepository.save(c);
		return "Saved";
	}

	@PostMapping(path = "/addlesson")
	public @ResponseBody String addNewLesson(@RequestParam String name, @RequestParam String description) {
		Lesson l = new Lesson();
		l.setName(name);
		l.setDescription(description);
		lessonRepository.save(l);
		return "Saved";
	}

	@GetMapping(path = "/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/courses")
	public @ResponseBody Iterable<Course> getAllCourses() {
		// This returns a JSON or XML with the users
		return courseRepository.findAll();
	}
	
	@GetMapping(path = "/lessons")
	public @ResponseBody Iterable<Lesson> getAllLessons() {
		// This returns a JSON or XML with the users
		return lessonRepository.findAll();
	}
	
}
