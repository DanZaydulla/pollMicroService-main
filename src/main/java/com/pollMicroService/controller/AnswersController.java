package com.pollMicroService.controller;

import com.pollMicroService.model.Answers;
import com.pollMicroService.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswersController {

    @Autowired
    private AnswersService answersService;

    @PostMapping
    public String createAnswer(@RequestBody Answers answers) {
        return answersService.createAnswer(answers);
    }

    @GetMapping
    public Answers getAnswersByQuestionId(@RequestParam int questionId) {
        return answersService.getAnswersByQuestionId(questionId);
    }

    @DeleteMapping(value = "/delete_answers_by_user_id/{userId}")
    public String deleteAnswersById(@PathVariable int userId) {
        return answersService.deleteAnswersById(userId);
    }


    @PutMapping
    public String updateAnswersById(@RequestBody Answers answers) {
        if(answers.getQuestionId() == 0 || answers.getAnswerOption() == null) {
            return "Can't change something to nothing";
        } else {
            return answersService.updateAnswersById(answers.getQuestionId(), answers.getAnswerOption());
        }
    }

    @GetMapping(value = "/by_user_id/{userId}")
    public List<Answers> findAnswersByUserId(@PathVariable int userId) {
        return answersService.findAnswersByUserId(userId);
    }
    @GetMapping("/all")
    public List<Answers> getAllAnswers() {
        return answersService.getAllAnswers();
    }
    @GetMapping("/users-answered/{questionId}")
    public int getTotalUsersAnsweredForQuestion(@PathVariable int questionId) {
        return answersService.getTotalUsersAnsweredForQuestion(questionId);
    }


}
