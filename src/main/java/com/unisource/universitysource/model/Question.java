package com.unisource.universitysource.model;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false, unique = true)
    private int questionId;

    @Column(name = "question_text", columnDefinition = "TEXT")
    private String questionText;

    @Column(name = "answer", columnDefinition = "TEXT")
    private String answer;

    @Column(name = "contributor", nullable = false)
    private String contributor;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type", nullable = false)
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
