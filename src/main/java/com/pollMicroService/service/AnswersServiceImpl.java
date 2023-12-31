package com.pollMicroService.service;

import com.pollMicroService.model.Answers;
import com.pollMicroService.repository.AnswersRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersServiceImpl implements AnswersService{

    @Autowired
    private AnswersRepositoryImpl answersRepository;



    @Override
    public String createAnswer(Answers answers) {
        return answersRepository.createAnswer(answers);
    }

    @Override
    public Answers getAnswersByQuestionId(int questionId) {
        return answersRepository.getAnswersByQuestionId(questionId);
    }

    @Override
    public String deleteAnswersById(int userId) {
        return answersRepository.deleteAnswersById(userId);

    }

    @Override
    public String updateAnswersById(int questionId, String answerOption) {
        return answersRepository.updateAnswersById(questionId, answerOption);
    }

    @Override
    public List<Answers> findAnswersByUserId(int userId) {
        return answersRepository.findAnswersByUserId(userId);

    }

    @Override
    public List<Answers> getAllAnswers() {
        return answersRepository.getAllAnswers();
    }
    @Override
    public int getTotalUsersAnsweredForQuestion(int questionId) {
        return answersRepository.getTotalUsersAnsweredForQuestion(questionId);
    }
}
