package com.example.quiz;

public class Question {

    private int ask;
    private boolean answer;
    private boolean userAnswer;

    public Question(int ask, boolean answer) {
        this.ask = ask;
        this.answer = answer;
    }

    public int getAsk() {
        return ask;
    }

    public boolean isAnswer() {
        return answer;
    }

    public boolean isUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }
}
