package com.example.coursework2.Controller;

import com.example.coursework2.Question;
import com.example.coursework2.Service.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
   private final ExaminerService examinerService;
@Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }

}
