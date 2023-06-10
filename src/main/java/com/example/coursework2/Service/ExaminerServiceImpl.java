package com.example.coursework2.Service;

import com.example.coursework2.Exception.ExceedingNumberQuestionsException;
import com.example.coursework2.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final  QuestionService questionService;

   public ExaminerServiceImpl(QuestionService questionService) {
    this.questionService = questionService;
   }

   @Override
        public Collection<Question> getQuestions(int amount) {
            if (amount <= 0 || questionService.getAll().size() < amount) {
                throw new ExceedingNumberQuestionsException("Количество вопросов больше, чем хранится в сервисе");
            }
            Set<Question> result = new HashSet<>();
            while (result.size() < amount){
                result.add(questionService.getRandomQuestion());
            }
            return result;
        }
    }

