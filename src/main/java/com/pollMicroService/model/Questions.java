package com.pollMicroService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Questions {
    @JsonProperty("id")
    private int questionId;
    private String question;
    @JsonProperty("answer_1")
    private String answer1;
    @JsonProperty("answer_2")
    private String answer2;
    @JsonProperty("answer_3")
    private String answer3;
    @JsonProperty("answer_4")
    private String answer4;

    public Questions(int questionId, String question, String answer1, String answer2, String answer3, String answer4) {
        this.questionId = questionId;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }
}
