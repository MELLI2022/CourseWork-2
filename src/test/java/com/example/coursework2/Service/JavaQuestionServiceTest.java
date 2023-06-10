package com.example.coursework2.Service;
import com.example.coursework2.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


class JavaQuestionServiceTest {
private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach(){
        questionService.add("Где можно объявить метод?",
                "Метод можно объявить внутри класса");
        questionService.add("Что такое стек?",
                "Пространство в памяти Java, которое хранит в себе переменные примитивных типов");
        questionService.add("Какие модификаторы доступа есть в Java? ",
                "public, default (package), protected, private");
        questionService.add("Что такое сборщик мусора в Java?",
                "Встроенный механизм в Java, который удаляет из памяти все недоступные или неиспользуемые объекты");
        questionService.add("Что такое пул строк?",
                "Механизм, который позволяет хранить в памяти компьютера только один экземпляр строки с идентичным содержанием");
    }
     @AfterEach
     public void afterEach(){
        new HashSet<>(questionService.getAll()).forEach(questionService ::remove);
     }

    @Test
    void add() {
        Question question = new Question("Какая сущность веб-приложения на Spring отвечает за обработку запросов?",
                "Класс-контроллер");

        assertThat(questionService.add(question))
                .isEqualTo(question)
                .isIn(questionService.getAll());
    }
    @Test
    public void addTest() {
        Question question = new Question("Какая сущность веб-приложения на Spring отвечает за обработку запросов?",
                "Класс-контроллер");

        assertThat(questionService.add("Какая сущность веб-приложения на Spring отвечает за обработку запросов?",
                "Класс-контроллер"))
                .isEqualTo(question)
                .isIn(questionService.getAll());
    }

   @Test
    void remove(){
       Question question = new Question("Где можно объявить метод?", "Метод можно объявить внутри класса");

        assertThat(questionService.remove(question))
                .isEqualTo(question)
                .isNotIn(questionService.getAll());
   }

@Test
public void getAllTest() {
    assertThat(questionService.getAll())
            .hasSize(5)
            .containsExactlyInAnyOrder(
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
}

@Test
public void getRandomQuestionTest() {
    assertThat(questionService.getRandomQuestion())
            .isNotNull()
            .isIn(questionService.getAll());
   }
}