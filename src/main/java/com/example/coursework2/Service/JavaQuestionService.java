package com.example.coursework2.Service;

import com.example.coursework2.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1;

    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
            return question;
    }

    @Override
    public  Collection<Question>  getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
          Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(randomIndex);
    }

}

