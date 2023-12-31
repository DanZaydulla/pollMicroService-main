package com.pollMicroService.repository;

import com.pollMicroService.repository.mapper.AnswersMapper;
import com.pollMicroService.model.Answers;
import com.pollMicroService.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnswersRepositoryImpl implements AnswersRepository{



    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String createAnswer(Answers answers) {
        String sql = "INSERT INTO " + Constants.ANSWERS_TABLE_NAME + " (question_id, answer_option, user_id) VALUES(?,?,?)";
        jdbcTemplate.update(sql, answers.getQuestionId(), answers.getAnswerOption(), answers.getUserId());
        return "User made his choice !";
    }

    @Override
    public Answers getAnswersByQuestionId(int questionId) {
        String sql = "SELECT * FROM " + Constants.ANSWERS_TABLE_NAME + " WHERE question_id = ?";
        return jdbcTemplate.queryForObject(sql, new AnswersMapper(), questionId);
    }

    @Override
    public String deleteAnswersById(int userId) {
        String sql = "DELETE FROM " + Constants.ANSWERS_TABLE_NAME + " WHERE user_id = ?";
        if(jdbcTemplate.update(sql, userId) >= 1) {
            return "Answers for user with ID " + userId + " were deleted";
        } else {
            return "No answers found for user with ID " + userId;
        }
    }

    @Override
    public String updateAnswersById(int questionId, String answerOption) {
        String sql = "UPDATE " + Constants.ANSWERS_TABLE_NAME + "SET answer_option = ? WHERE question_id = ?";
        if(jdbcTemplate.update(sql, questionId, answerOption) == 1) {
            return "Answer to question with id " + questionId + " changed to " + answerOption;
        } else {
            return "Answer to question with id " + questionId + " wasn't found";
        }
    }
    @Override
    public List<Answers> findAnswersByUserId(int userId) {
        String sql = "SELECT * FROM answers WHERE user_id = ?";
        return jdbcTemplate.query(sql, new AnswersMapper(), userId);
    }

    @Override
    public List<Answers> getAllAnswers() {
        String sql = "SELECT * FROM answers";
        return jdbcTemplate.query(sql, new AnswersMapper());
    }

    @Override
    public int getTotalUsersAnsweredForQuestion(int questionId) {
        String sql = "SELECT COUNT(DISTINCT user_id) FROM " + Constants.ANSWERS_TABLE_NAME + " WHERE question_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, questionId);
    }
}
