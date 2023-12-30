package com.pollMicroService.service;

import com.pollMicroService.model.Answers;
import com.pollMicroService.model.Questions;

import java.util.List;

public interface QuestionsService {

    String createQuestions(Questions questions);
    Questions getQuestionById(int questionId);
    String deleteQuestionById(int questionId);
    String updateQuestionById(int questionId, String question);
    List<Questions> getAllQuestions();
    int countUserAnswersByQuestionId(int questionId);
}
