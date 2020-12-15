package sample.model;

/*
QuestionsDecorator class represent Decorator design pattern.
 */
public abstract class QuestionDecorator implements IQuestion {

    private Question question;

    public QuestionDecorator(Question question) {
        this.question = question;
    }

    @Override
    public int calculatePoints() {
        return question.calculatePoints();
    }
}
