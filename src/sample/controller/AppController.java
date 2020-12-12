package sample.controller;

import sample.model.*;

import java.util.Arrays;

public abstract class AppController implements IInitializable {

    GoTo goTo = new GoTo();
    static Questions questions = new Questions();

    public void createOneChoiceQuestions() {
        QuestionWithOneChoice question1 = new QuestionWithOneChoice();
        question1.setContent("Apple:");
        question1.answers = Arrays.asList("la manzana", "la calabaza", "el plátano", "la cereza");
        question1.correctAnswer = 0;
        question1.state = new NonAnsweredState(question1);
        QuestionWithOneChoice question2 = new QuestionWithOneChoice();
        question2.setContent("Raspberry:");
        question2.answers = Arrays.asList("la frambuesa", "la naranja", "el aguacate", "la cereza");
        question2.correctAnswer = 0;
        question2.state = new NonAnsweredState(question2);
        questions.addQuestion(question1);
        questions.addQuestion(question2);
    }

    public void createInputQuestions() {
        QuestionWithInput question1 = new QuestionWithInput();
        question1.setContent("Apple:");
        question1.correctAnswer = "la manzana";
        question1.state = new NonAnsweredState(question1);
        QuestionWithInput question2 = new QuestionWithInput();
        question2.setContent("Raspberry:");
        question2.correctAnswer = "la frambuesa";
        question2.state = new NonAnsweredState(question2);
        questions.addQuestion(question1);
        questions.addQuestion(question2);
    }
}
