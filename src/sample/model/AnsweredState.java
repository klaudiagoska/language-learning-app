package sample.model;

import javafx.scene.control.Label;

/*
AnsweredState class represents State design pattern.
 */
public class AnsweredState extends State {

    public AnsweredState(Question question) {
        super(question);
    }

    @Override
    public void clickAnswer(Label label) {
        label.setText("You can't answer again!");
    }

    @Override
    public void clickNext(Label label) {
        label.setText("");
    }
}
