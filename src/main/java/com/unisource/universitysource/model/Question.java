package com.unisource.universitysource.model;

public class Question {
    private int questionId;
    private String questionText;
    private String answer;
    private String contributor;
    private ExamQuestionsType type;

    public Question(String questionText, String answer, String contributor, ExamQuestionsType type) {
        this.questionText = questionText;
        this.answer = answer;
        this.contributor = contributor;
        this.type = type;
    }

    public Question() {

    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public ExamQuestionsType getType() {
        return type;
    }

    public void setType(ExamQuestionsType type) {
        this.type = type;
    }
}
