package com.pollMicroService.repository;

import com.pollMicroService.model.Answers;
import com.pollMicroService.model.Questions;

import java.util.List;

public interface QuestionsRepository {

    String createQuestions(Questions questions);
    Questions getQuestionById(int questionId);
    String deleteQuestionById(int questionId);
    String updateQuestionById(int questionId, String question);
    List<Questions> getAllQuestions();


}
