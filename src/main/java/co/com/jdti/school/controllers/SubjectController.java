package co.com.jdti.school.controllers;

import co.com.jdti.school.model.entities.Subject;
import co.com.jdti.school.services.ISubjectServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Slf4j
@Controller
public class SubjectController {

    private final ISubjectServices iSubjectServices;

    public SubjectController(ISubjectServices iSubjectServices) {
        this.iSubjectServices = iSubjectServices;
    }

    @GetMapping({"/subjects"})
    public String subjects(Model model) {
        model.addAttribute("title", "Subjects");
        model.addAttribute("subjects", iSubjectServices.findAll());
        return "subjects";
    }

    @GetMapping({"/subject/{id}"})
    public String subjectDetail(Model model, @PathVariable String id) {
        model.addAttribute("title", "Details");
        Optional<Subject> subjectOptional = iSubjectServices.findById(Long.parseLong(id));
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();
            model.addAttribute("subject", subject);
        } else {
            model.addAttribute("subject", "");
        }
        return "subjectDetail";
    }
}
