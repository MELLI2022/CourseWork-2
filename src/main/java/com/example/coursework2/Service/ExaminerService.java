package com.example.coursework2.Service;
import com.example.coursework2.Question;

import java.util.Collection;


public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
