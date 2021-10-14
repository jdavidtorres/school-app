package co.com.jdti.school.controllers;

import co.com.jdti.school.dtos.StudentBySubject;
import co.com.jdti.school.model.entities.Course;
import co.com.jdti.school.model.entities.Student;
import co.com.jdti.school.services.CoursesServices;
import co.com.jdti.school.services.ScheduleServices;
import co.com.jdti.school.services.StudentServices;
import co.com.jdti.school.services.SubjectServices;
import co.com.jdti.school.services.TeacherServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final StudentServices studentServices;
    private final CoursesServices coursesServices;
    private final TeacherServices teacherServices;
    private final SubjectServices subjectServices;
    private final ScheduleServices scheduleServices;

    private List<Student> getStudents() {
        return studentServices.findAll();
    }

    @RequestMapping({"", "/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "SchoolApp");
        model.addAttribute("courses", coursesServices.findAll());
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
    public String save(@Valid @ModelAttribute Student student, BindingResult result, Model model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Crear Factura");
            flash.addFlashAttribute("error", "Complete the form please!!");
            result.getFieldErrors().forEach(err -> log.error(err.getField()));
            return "redirect:/new-student";
        }
        studentServices.save(student);
        flash.addFlashAttribute("success", "Factura creada con éxito!");
        return "redirect:/index";
    }

    @RequestMapping({"/students"})
    public String students(Model model) {
        model.addAttribute("title", "Students");
        model.addAttribute("students", studentServices.findAll());
        return "students";
    }

    @RequestMapping({"/student/{id}"})
    public String studentDetail(Model model, @PathVariable String id) {
        model.addAttribute("title", "Details");
        Optional<Student> studentOptional = studentServices.findById(Long.parseLong(id));
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
        Optional<Course> courseOptional = coursesServices.findById(Long.parseLong(id));
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            model.addAttribute("title", "Course " + course.getName());
            model.addAttribute("course", course);
            model.addAttribute("students", studentServices.findByCourseId(course.getId()));
            model.addAttribute("schedules", scheduleServices.findByCourseId(course.getId()));
            return "courseDetails";
        }
        return "redirect:/index";
    }

    @GetMapping("/course/{id}/teacher/{teacherId}")
    public String courseDetailsByTeacher(@PathVariable String id, @PathVariable String teacherId, Model model) {
        Optional<Course> courseOptional = coursesServices.findById(Long.parseLong(id));
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            model.addAttribute("title", "Course " + course.getName());
            model.addAttribute("course", course);
            model.addAttribute("students", studentServices.findByCourseId(course.getId()));
            model.addAttribute("schedules", scheduleServices.findByCourseId(course.getId()));
            model.addAttribute("studentsSubject", new StudentBySubject());
            return "courseDetails";
        }
        return "redirect:/index";
    }

    @GetMapping("/edit-course/{id}")
    public String addStudentToCourse(@PathVariable String id, Model model) {
        Optional<Course> courseOptional = coursesServices.findById(Long.parseLong(id));
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
        Optional<Student> studentOptional = studentServices.findByDni(dni);
        if (studentOptional.isPresent()) {
            flash.addFlashAttribute("student", studentOptional.get());
        }
        return "redirect:/edit-course/" + courseId;
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestParam String courseId, @RequestParam String dni) {
        Optional<Student> studentOptional = studentServices.findByDni(dni);
        Student student = studentOptional.get();
        student.setCourseId(Long.parseLong(courseId));
        studentServices.save(student);
        return "redirect:/edit-course/" + courseId;
    }
}
