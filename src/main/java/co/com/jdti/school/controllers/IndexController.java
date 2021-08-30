package co.com.jdti.school.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.jdti.school.model.entities.Course;
import co.com.jdti.school.model.entities.Student;
import co.com.jdti.school.services.ICourseServices;
import co.com.jdti.school.services.IStudentServices;
import co.com.jdti.school.services.ISubjectServices;
import co.com.jdti.school.services.ITeacherServices;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	@Autowired
	private IStudentServices iStudentServices;

	@Autowired
	private ICourseServices iCourseServices;

	@Autowired
	private ITeacherServices iTeacherServices;

	@Autowired
	private ISubjectServices iSubjectServices;

	private List<Student> getStudents() {
		return iStudentServices.findAll();
	}

	@RequestMapping({ "", "/", "/index" })
	public String index(Model model) {
		model.addAttribute("title", "SchoolApp");
		model.addAttribute("courses", iCourseServices.findAll());
		model.addAttribute("students", getStudents());
		return "index";
	}

	@GetMapping("/new-student")
	public String newStudent(Model model) {
		model.addAttribute("title", "New Student");
		model.addAttribute("student", new Student());
		return "newStudent";
	}

	@PostMapping("/save-student")
	public String save(@Valid @ModelAttribute Student student, BindingResult result, Model model,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear Factura");
			flash.addFlashAttribute("error", "Complete the form please!!");
			result.getFieldErrors().forEach(err -> log.error(err.getField()));
			return "redirect:/new-student";
		}
		iStudentServices.save(student);
		flash.addFlashAttribute("success", "Factura creada con Éxito!");
		return "redirect:/index";
	}

	@RequestMapping({ "/students" })
	public String students(Model model) {
		model.addAttribute("title", "Students");
		model.addAttribute("students", iStudentServices.findAll());
		return "students";
	}

	@RequestMapping({ "/student/{id}" })
	public String studentDetail(Model model, @PathVariable String id) {
		model.addAttribute("title", "Details");
		Optional<Student> studentOptional = iStudentServices.findById(id);
		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			model.addAttribute("student", student);
		} else {
			model.addAttribute("student", "");
		}
		return "studentDetails";
	}

	@GetMapping("/new-course")
	public String newCourse(Model model) {
		model.addAttribute("title", "New Course");
		model.addAttribute("course", new Course());
		return "newCourse";
	}

	@GetMapping("/course/{id}")
	public String courseDetails(@PathVariable String id, Model model) {
		Optional<Course> courseOptional = iCourseServices.findById(id);
		if (courseOptional.isPresent()) {
			Course course = courseOptional.get();
			model.addAttribute("title", "Course " + course.getName());
			model.addAttribute("course", course);
			return "courseDetails";
		}
		return "redirect:/index";
	}

	@GetMapping("/edit-course/{id}")
	public String addStudentToCourse(@PathVariable String id, Model model) {
		Optional<Course> courseOptional = iCourseServices.findById(id);
		if (courseOptional.isPresent()) {
			Course course = courseOptional.get();
			model.addAttribute("title", "Course " + course.getName());
			model.addAttribute("course", course);
			return "editCourse";
		}
		return "redirect:/index";
	}

	@PostMapping("/get-student")
	public String getStudent(@RequestParam String dni, @RequestParam String courseId, RedirectAttributes flash) {
		Optional<Student> studentOptional = iStudentServices.findByDni(dni);
		if (studentOptional.isPresent()) {
			flash.addFlashAttribute("student", studentOptional.get());
		}
		return "redirect:/edit-course/" + courseId;
	}

	@PostMapping("/add-student")
	public String addStudent(@RequestParam String courseId, @RequestParam String dni) {
		Optional<Student> studentOptional = iStudentServices.findByDni(dni);
		Student student = studentOptional.get();
		student.setCourse(new Course(courseId));
		iStudentServices.save(student);
		return "redirect:/edit-course/" + courseId;
	}

	@RequestMapping({ "/subjects" })
	public String subjects(Model model) {
		model.addAttribute("title", "Subjects");
		model.addAttribute("subjects", iSubjectServices.findAll());
		return "subjects";
	}
}
