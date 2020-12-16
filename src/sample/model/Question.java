package sample.model;

import javafx.scene.control.Label;

public abstract class Question {

    private String content;
    public State state;
    public String correctAnswer;
    public String userAnswer;

    public Question() {}

    public Question(String content, String correctAnswer) {
        this.content = content;
        this.correctAnswer = correctAnswer;
        state = new NonAnsweredState(this);
    }

    public Question(Question question) {
        if (question != null) {
            content = question.content;
            state = question.state;
            correctAnswer = question.correctAnswer;
            userAnswer = question.userAnswer;
        }
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void clickAnswer(Label label) {
        state.clickAnswer(label);
    }

    public void clickNext(Label label) {
        state.clickNext(label);
    }

    public int calculatePoints() {
        return 1;
    }

    public boolean correct() {
        return correctAnswer.equals(userAnswer);
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /*
    clone() method represents Prototype design pattern.
     */
    public abstract Question clone();

}
