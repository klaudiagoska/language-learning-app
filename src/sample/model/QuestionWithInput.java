package sample.model;

public class QuestionWithInput extends Question {

    public QuestionWithInput() {}

    public QuestionWithInput(String content, String correctAnswer) {
        super(content, correctAnswer);
    }

    public QuestionWithInput(QuestionWithInput questionWithInput) {
        super(questionWithInput);
    }

    @Override
    public Question clone() {
        return new QuestionWithInput(this);
    }
}
