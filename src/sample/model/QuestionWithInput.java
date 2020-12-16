package sample.model;

public class QuestionWithInput extends Question {

    public QuestionWithInput() {}

    public QuestionWithInput(QuestionWithInput questionWithInput) {
        super(questionWithInput);
    }

    @Override
    public Question clone() {
        return new QuestionWithInput(this);
    }
}
