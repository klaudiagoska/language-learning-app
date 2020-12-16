package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import sample.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class End extends AppController {
    public Label score;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double correctAnswers = questions.correctAnswersAmount;
        double questionsAmount = questions.size();
        if (correctAnswers >= 0.75 * questionsAmount) {
            User.getINSTANCE().notifyObservers();
        }
        displayScore();
    }

    private void displayScore() {
        String s = "Your score: " + User.getINSTANCE().getScore();
        if (User.getINSTANCE().getScore() == 1) {
            s += " point";
        } else {
            s += " points";
        }
        score.setText(s);
    }

    public void goToQuestionsSummary(ActionEvent actionEvent) {
        goTo.execute(actionEvent, "../view/questionsSummary.fxml");
    }
}
