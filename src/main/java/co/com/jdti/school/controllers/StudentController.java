package co.com.jdti.school.controllers;

import co.com.jdti.school.services.StudentServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentController {

    private final IStudentServices iStudentServices;

    public StudentController(IStudentServices iStudentServices) {
        this.iStudentServices = iStudentServices;
    }

    @GetMapping({"/students"})
    public String students(Model model) {
        model.addAttribute("title", "Students");
        model.addAttribute("students", iStudentServices.findAll());
        return "students";
    }
}