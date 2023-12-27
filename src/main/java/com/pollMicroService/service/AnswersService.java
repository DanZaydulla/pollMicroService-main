package com.pollMicroService.service;

import com.pollMicroService.model.Answers;

import java.util.List;

public interface AnswersService {

    String createAnswer(Answers answers);
    Answers getAnswersByQuestionId(int questionId);
    String deleteAnswersById(int questionId);
    String updateAnswersById(int questionId, String answerOption);
    List<Answers> findAnswersByUserId(int userId);
}
