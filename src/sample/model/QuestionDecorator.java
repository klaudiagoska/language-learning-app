package sample.model;

/*
QuestionsDecorator class represent Decorator design pattern.
 */
public abstract class QuestionDecorator extends Question {

    private Question question;

    public QuestionDecorator(Question question) {
        super(question);
        this.question = question;
    }

    @Override
    public int calculatePoints() {
        return question.calculatePoints();
    }
}
