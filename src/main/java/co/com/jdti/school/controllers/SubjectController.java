package co.com.jdti.school.controllers;

import co.com.jdti.school.model.entities.Subject;
import co.com.jdti.school.services.SubjectServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectServices subjectServices;

    @GetMapping({"/subjects"})
    public String subjects(Model model) {
        model.addAttribute("title", "Subjects");
        model.addAttribute("subjects", subjectServices.findAll());
        return "subjects";
    }

    @GetMapping({"/subject/{id}"})
    public String subjectDetail(Model model, @PathVariable String id) {
        model.addAttribute("title", "Details");
        Optional<Subject> subjectOptional = subjectServices.findById(Long.parseLong(id));
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();
            model.addAttribute("subject", subject);
        } else {
            model.addAttribute("subject", "");
        }
        return "subjectDetail";
    }
}
