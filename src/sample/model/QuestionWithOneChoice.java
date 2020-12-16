package sample.model;

import java.util.*;

public class QuestionWithOneChoice extends Question {

    public List<String> answers;

    public QuestionWithOneChoice() {}

    public QuestionWithOneChoice(String content, String correctAnswer, List<String> answers) {
        super(content, correctAnswer);
        this.answers = List.copyOf(answers);
    }

    public QuestionWithOneChoice(QuestionWithOneChoice question) {
        super(question);
        if (question != null) {
            answers = List.copyOf(question.answers);
        }
    }

    public void shuffle() {
        Random r = new Random();
        List<Integer> l = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(l, r);
        String[] tmp = new String[4];
        for (int i = 0; i < 4; i++) {
            tmp[l.get(i)] = answers.get(i);
        }
        answers = Arrays.asList(tmp);
    }

    @Override
    public Question clone() {
        return new QuestionWithOneChoice(this);
    }
}
