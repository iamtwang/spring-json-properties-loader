package io.github.iamtwang.loader.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Tao
 */
@Component
@ConfigurationProperties(prefix = "io.github.iamtwang")
public class QuizJsonProperties {

    private Map<String, Object> quiz;

    public Map<String, Object> getQuiz() {
        return quiz;
    }

    public void setQuiz(Map<String, Object> quiz) {
        this.quiz = quiz;
    }
}
