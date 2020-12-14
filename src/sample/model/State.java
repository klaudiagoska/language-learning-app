package sample.model;

import javafx.scene.control.Label;

public abstract class State {

    Question question;

    public State(Question question) {
        this.question = question;
    }

    public abstract void clickAnswer(Label label);
    public abstract void clickNext(Label label);

}
