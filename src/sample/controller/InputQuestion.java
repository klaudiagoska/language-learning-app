package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class InputQuestion extends AppController{
    public Label alert;
    public Label question;
    public TextField userAnswer;
    private Question currentQuestion;
    private final IIterator iterator = questions.createIterator();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateQuestion();
        displayQuestion();
    }

    private void updateQuestion() {
        currentQuestion = iterator.next();
    }

    private void displayQuestion() {
        alert.setText("");
        userAnswer.setText("");
        question.setText(currentQuestion.getContent());
    }

    public void answer(ActionEvent actionEvent) {
        if (isAnswer()) {
            if (currentQuestion.state instanceof NonAnsweredState) {
                currentQuestion.clickAnswer(alert);
                setSelectedAnswer();
                checkAnswer();
            } else if (currentQuestion.state instanceof AnsweredState) {
                currentQuestion.clickAnswer(alert);
            }
        } else {
            alert.setText("You have to write the answer.");
        }
    }

    public void nextQuestion(ActionEvent actionEvent) {
        if (currentQuestion.state instanceof AnsweredState) {
            currentQuestion.clickNext(alert);
            updateQuestion();
            if (currentQuestion != null) {
                displayQuestion();
            } else {
                goTo.execute(actionEvent, "../view/end.fxml");
            }
        } else {
            currentQuestion.clickNext(alert);
        }
    }

    private boolean isAnswer() {
        return !userAnswer.getText().equals("");
    }

    private void setSelectedAnswer() {
        currentQuestion.userAnswer = userAnswer.getText();
    }

    private void checkAnswer() {
        if (currentQuestion.correctAnswer.equals(userAnswer.getText())) {
            User.getINSTANCE().addPoints(currentQuestion.calculatePoints());
            questions.correctAnswersAmount++;
        }
    }
}
