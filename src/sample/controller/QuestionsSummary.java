package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import sample.model.IIterator;
import sample.model.Question;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionsSummary extends AppController {
    public Label question;
    public Label userAnswer;
    public Label correctAnswer;
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
        if (currentQuestion.correct()) {
            displayCorrectQuestion(currentQuestion.clone());
        } else {
            displayIncorrectQuestion(currentQuestion.clone());
        }
    }

    private void displayCorrectQuestion(Question correctQuestion) {
        question.setText(correctQuestion.getContent());
        userAnswer.setText("Your answer: " + correctQuestion.getUserAnswer() + " is correct!");
        correctAnswer.setText("");
    }

    private void displayIncorrectQuestion(Question incorrectQuestion) {
        question.setText(incorrectQuestion.getContent());
        userAnswer.setText("Your answer: " + incorrectQuestion.getUserAnswer() + " is incorrect!");
        correctAnswer.setText("Correct answer is: " + incorrectQuestion.getCorrectAnswer());
    }

    public void nextQuestion(ActionEvent actionEvent) {
        updateQuestion();
        if (currentQuestion != null) {
            displayQuestion();
        } else {
            goTo.execute(actionEvent, "../view/endOfGame.fxml");
        }
    }

    public void goToMenu(ActionEvent actionEvent) {
        goTo.execute(actionEvent, "../view/menu.fxml");
    }

    public void end(ActionEvent actionEvent) {
        System.exit(0);
    }
}
