package cs499.cpp.edu.quizdemoapp.model;

/**
 * Created by yusun on 4/3/17.
 */

public class QuizQuestion {

    private String title;
    private boolean correctAnswer;

    public QuizQuestion() {
    }

    public QuizQuestion(String title, boolean correctAnswer) {
        this.title = title;
        this.correctAnswer = correctAnswer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
