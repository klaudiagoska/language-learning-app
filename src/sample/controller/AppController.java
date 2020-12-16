package sample.controller;

import sample.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Implementing IInitializable interface (overriding initialize method)
and extending AppController class by other class in controller package
represent Template method design pattern.
 */
public abstract class AppController implements IInitializable {

    GoTo goTo = new GoTo();
    static Questions questions = new Questions();

    public void createOneChoiceQuestions() {
        init();
        List<Question> questionList = new ArrayList<>();
        QuestionWithOneChoice question1 = new QuestionWithOneChoice();
        question1.setContent("Apple");
        question1.answers = Arrays.asList("la manzana", "la calabaza", "el plátano", "la cereza");
        question1.correctAnswer = "la manzana";
        question1.state = new NonAnsweredState(question1);
        QuestionWithOneChoice question2 = new QuestionWithOneChoice();
        question2.setContent("Raspberry");
        question2.answers = Arrays.asList("la frambuesa", "la naranja", "el aguacate", "la cereza");
        question2.correctAnswer = "la frambuesa";
        question2.state = new NonAnsweredState(question2);

        questionList.add(question1);
        questionList.add(question2);

        addQuestions(questionList);
    }

    public void createInputQuestions() {
        init();
        List<Question> questionList = new ArrayList<>();
        Question question1 = new QuestionWithInput();
        question1.setContent("Apple");
        question1.correctAnswer = "la manzana";
        question1.state = new NonAnsweredState(question1);
        Question question2 = new QuestionWithInput();
        question2.setContent("Raspberry");
        question2.correctAnswer = "la frambuesa";
        question2.state = new NonAnsweredState(question2);

        Question question = new QuestionWithBonus(new QuestionWithInput());
        question.setContent("TEST");
        question.correctAnswer = "ans";
        question.state = new NonAnsweredState(question);

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question);

        addQuestions(questionList);
    }

    private void addQuestions(List<Question> questionList) {
        Collections.shuffle(questionList);
        for (int i = 0; i < 3; i++) {
            questions.addQuestion(questionList.get(i));
        }
    }

    private void init() {
        User.getINSTANCE().clearScore();
        questions.clear();
        questions.correctAnswersAmount = 0;
    }
}
