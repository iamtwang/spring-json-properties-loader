package io.github.iamtwang.loader.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.iamtwang.loader.pojo.QuizJsonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tao
 */
@RestController
@RefreshScope
public class QuizController {

    @Autowired
    private QuizJsonProperties quizJsonProperties;

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping(value = "/quiz")
    public JsonNode getQuiz(){

        return objectMapper.valueToTree(quizJsonProperties.getQuiz());
    }
}
