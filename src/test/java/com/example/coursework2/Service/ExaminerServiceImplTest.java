package com.example.coursework2.Service;
import com.example.coursework2.Exception.ExceedingNumberQuestionsException;
import com.example.coursework2.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Collection<Question> questions = Set.of(
    new Question("Где можно объявить метод?",
            "Метод можно объявить внутри класса"),
        new Question("Что такое стек?",
                "Пространство в памяти Java, которое хранит в себе переменные примитивных типов"),
         new Question("Какие модификаторы доступа есть в Java? ",
                "public, default (package), protected, private"),
         new Question("Что такое сборщик мусора в Java?",
                "Встроенный механизм в Java, который удаляет из памяти все недоступные или неиспользуемые объекты"),
         new Question("Что такое пул строк?",
                "Механизм, который позволяет хранить в памяти компьютера только один экземпляр строки с идентичным содержанием")
);
    @Test
    public void getQuestions() {
        when(questionService.getAll()).thenReturn(questions);

        when(questionService.getRandomQuestion()).thenReturn(
                new Question("Где можно объявить метод?",
                        "Метод можно объявить внутри класса"),
                new Question("Что такое стек?",
                        "Пространство в памяти Java, которое хранит в себе переменные примитивных типов"),
                new Question("Где можно объявить метод?",
                        "Метод можно объявить внутри класса"),
                new Question("Что такое стек?",
                        "Пространство в памяти Java, которое хранит в себе переменные примитивных типов")
        );

        assertThat(examinerService.getQuestions(2))
                .hasSize(2)
                .containsExactlyInAnyOrder(
                        new Question("Где можно объявить метод?",
                                "Метод можно объявить внутри класса"),
                        new Question("Что такое стек?",
                                "Пространство в памяти Java, которое хранит в себе переменные примитивных типов")
                                        );
    }
    @Test
    public void getQuestionsNegative() {
        when(questionService.getAll()).thenReturn(questions);

        assertThatExceptionOfType(ExceedingNumberQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        assertThatExceptionOfType(ExceedingNumberQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(questions.size() + 1));
    }
    @Test
    void ExceedingNumberQuestionsExceptionTest(){
        assertThatExceptionOfType(ExceedingNumberQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(5));
    }
}