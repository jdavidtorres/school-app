package co.com.jdti.school.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/student-view")
public class StudentViewController {

    private List<String> references = new ArrayList<>();

    @GetMapping("/{studentId}")
    public String myDetailsAsStudent(@PathVariable String studentId, Model model) {
        model.addAttribute("title", "SchoolApp");
        references = new ArrayList<>();
        references.add("Reference 1");
        references.add("Reference 2");
        references.add("Reference 3");
        model.addAttribute("references", references);
        return "student/student-view";
    }
}
