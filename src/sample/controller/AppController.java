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
        initGame();
        List<Question> questionList = new ArrayList<>();

        QuestionWithOneChoice question1 = new QuestionWithOneChoice("Apple", "la manzana",
                List.of("la manzana", "la calabaza", "el plátano", "la cereza"));
        questionList.add(question1);

        QuestionWithOneChoice question2 = new QuestionWithOneChoice("Raspberry", "la frambuesa",
                List.of("la frambuesa", "la naranja", "el aguacate", "la cereza"));
        questionList.add(question2);

        QuestionWithOneChoice question3 = new QuestionWithOneChoice("Potato", "la patata",
                List.of("la patata", "las alubias", "la calabaza", "el calabacín"));
        questionList.add(question3);

        QuestionWithOneChoice question4 = new QuestionWithOneChoice("Carrot", "la zanahoria",
                List.of("la zanahoria", "el champiñón", "la piña", "la fresa"));
        questionList.add(question4);

        QuestionWithOneChoice question5 = new QuestionWithOneChoice("Paprika", "el pimiento",
                List.of("el pimiento", "el apio", "la piña", "la remolacha"));
        questionList.add(question5);

        QuestionWithOneChoice question6 = new QuestionWithOneChoice("Dog", "el perro",
                List.of("el perro", "la águila", "el gato", "el pájaro"));
        questionList.add(question6);

        QuestionWithOneChoice question7 = new QuestionWithOneChoice("Cat", "el gato",
                List.of("el gato", "el perro", "el caballo", "la vaca"));
        questionList.add(question7);

        QuestionWithOneChoice question8 = new QuestionWithOneChoice("Bird", "el pájaro",
                List.of("el pájaro", "el gato", "el caballo", "la vaca"));
        questionList.add(question8);

        QuestionWithOneChoice question9 = new QuestionWithOneChoice("Monkey", "la mono",
                List.of("la mono", "el cerdo", "el pájaro", "el perro"));
        questionList.add(question9);

        QuestionWithOneChoice question10 = new QuestionWithOneChoice("Horse", "el caballo",
                List.of("el caballo", "el cerdo", "el pájaro", "la águila"));
        questionList.add(question10);

        QuestionWithOneChoice question11 = new QuestionWithOneChoice("Hand", "la mano",
                List.of("la mano", "el codo", "la pierna", "el tobillo"));
        questionList.add(question11);

        QuestionWithOneChoice question12 = new QuestionWithOneChoice("Nose", "la nariz",
                List.of("la nariz", "el hombro", "la pierna", "el ombligo"));
        questionList.add(question12);

        QuestionWithOneChoice question13 = new QuestionWithOneChoice("Mouth", "la boca",
                List.of("la boca", "el cuello", "el estómago", "el ombligo"));
        questionList.add(question13);

        QuestionWithOneChoice question14 = new QuestionWithOneChoice("Foot", "el pie",
                List.of("el pie", "la rodilla", "el pecho", "la mano"));
        questionList.add(question14);

        QuestionWithOneChoice question15 = new QuestionWithOneChoice("Eye", "ej ojo",
                List.of("ej ojo", "la rodilla", "el hombro", "la boca"));
        questionList.add(question15);

        initQuestions(questionList);
    }

    public void createInputQuestions() {
        initGame();
        List<Question> questionList = new ArrayList<>();
        Question question1 = new QuestionWithInput("Apple", "la manzana");
        questionList.add(question1);

        Question question2 = new QuestionWithBonus(new QuestionWithInput("Raspberry", "la frambuesa"));
        questionList.add(question2);

        Question question3 = new QuestionWithInput("Potato", "la patata");
        questionList.add(question3);

        Question question4 = new QuestionWithInput("Carrot", "la zanahoria");
        questionList.add(question4);

        Question question5 = new QuestionWithBonus(new QuestionWithInput("Paprika", "el pimiento"));
        questionList.add(question5);

        Question question6 = new QuestionWithInput("Dog", "el perro");
        questionList.add(question6);

        Question question7 = new QuestionWithInput("Cat", "el gato");
        questionList.add(question7);

        Question question8 = new QuestionWithInput("Bird", "el pájaro");
        questionList.add(question8);

        Question question9 = new QuestionWithInput("Monkey", "la mono");
        questionList.add(question9);

        Question question10 = new QuestionWithBonus(new QuestionWithInput("Horse", "el caballo"));
        questionList.add(question10);

        QuestionWithInput question11 = new QuestionWithInput("Hand", "la mano");
        questionList.add(question11);

        QuestionWithInput question12 = new QuestionWithInput("Nose", "la nariz");
        questionList.add(question12);

        Question question13 = new QuestionWithBonus(new QuestionWithInput("Mouth", "la boca"));
        questionList.add(question13);

        QuestionWithInput question14 = new QuestionWithInput("Foot", "el pie");
        questionList.add(question14);

        QuestionWithInput question15 = new QuestionWithInput("Eye", "ej ojo");
        questionList.add(question15);

        initQuestions(questionList);
    }

    private void initQuestions(List<Question> questionList) {
        Collections.shuffle(questionList);
        for (int i = 0; i < questionList.size() / 2 + 1; i++) {
            questions.addQuestion(questionList.get(i));
        }
    }

    private void initGame() {
        User.getINSTANCE().clearScore();
        questions.clear();
        questions.correctAnswersAmount = 0;
    }
}
