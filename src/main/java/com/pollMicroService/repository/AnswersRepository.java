package com.pollMicroService.repository;

import com.pollMicroService.model.Answers;

import java.util.List;

public interface AnswersRepository {

    String createAnswer(Answers answers);
    Answers getAnswersByQuestionId(int questionId);
    String deleteAnswersById(int userId);
    String updateAnswersById(int questionId, String answerOption);
    List<Answers> findAnswersByUserId(int userId);
    List<Answers> getAllAnswers();
    int getTotalUsersAnsweredForQuestion(int questionId);

}
