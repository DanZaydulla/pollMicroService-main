package com.pollMicroService.repository.mapper;

import com.pollMicroService.model.Answers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswersMapper implements RowMapper<Answers> {
    @Override
    public Answers mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Answers(
                rs.getInt("id"),
                rs.getInt("question_id"),
                rs.getString("answer_option"),
                rs.getInt("user_id"));
    }
}
