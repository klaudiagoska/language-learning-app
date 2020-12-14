package sample.controller;

import sample.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AppController implements IInitializable {

    GoTo goTo = new GoTo();
    static Questions questions = new Questions();

    public void createOneChoiceQuestions() {
        User.getINSTANCE().clearScore();
        questions.clear();
        List<Question> questionsList = new ArrayList<>();
        QuestionWithOneChoice question1 = new QuestionWithOneChoice();
        question1.setContent("Apple:");
        question1.answers = Arrays.asList("la manzana", "la calabaza", "el plátano", "la cereza");
        question1.correctAnswer = "la manzana";
        question1.state = new NonAnsweredState(question1);
        QuestionWithOneChoice question2 = new QuestionWithOneChoice();
        question2.setContent("Raspberry:");
        question2.answers = Arrays.asList("la frambuesa", "la naranja", "el aguacate", "la cereza");
        question2.correctAnswer = "la frambuesa";
        question2.state = new NonAnsweredState(question2);
        questionsList.add(question1);
        questionsList.add(question2);
        Collections.shuffle(questionsList);
        addQuestions(questionsList);
    }

    public void createInputQuestions() {
        User.getINSTANCE().clearScore();
        questions.clear();
        List<Question> questionList = new ArrayList<>();
        QuestionWithInput question1 = new QuestionWithInput();
        question1.setContent("Apple:");
        question1.correctAnswer = "la manzana";
        question1.state = new NonAnsweredState(question1);
        QuestionWithInput question2 = new QuestionWithInput();
        question2.setContent("Raspberry:");
        question2.correctAnswer = "la frambuesa";
        question2.state = new NonAnsweredState(question2);
        questionList.add(question1);
        questionList.add(question2);
        Collections.shuffle(questionList);
        addQuestions(questionList);
    }

    private void addQuestions(List<Question> questionList) {
        for (int i = 0; i < questionList.size() / 2; i++) {
            questions.addQuestion(questionList.get(i));
        }
    }
}
