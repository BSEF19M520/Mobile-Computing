package com.example.appforkids;

public class ExamItem {
    private int imageId;
    private String correctAnswer;
    private String selectedAnswer;
    private int correctAnswerRadioButtonId;
    private int selectedAnswerRadioButtonId;

    public ExamItem(int imageId, String correctAnswer) {
        this.imageId = imageId;
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswerRadioButtonId() {
        return correctAnswerRadioButtonId;
    }

    public void setCorrectAnswerRadioButtonId(int correctAnswerRadioButtonId) {
        this.correctAnswerRadioButtonId = correctAnswerRadioButtonId;
    }

    public int getSelectedAnswerRadioButtonId() {
        return selectedAnswerRadioButtonId;
    }

    public void setSelectedAnswerRadioButtonId(int selectedAnswerRadioButtonId) {
        this.selectedAnswerRadioButtonId = selectedAnswerRadioButtonId;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
