package coursework.service.impl;

import coursework.entity.Question;
import coursework.service.ExaminerService;
import coursework.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount>questionService.size()){
            throw new IllegalArgumentException("Всего максимум вопросов = " + questionService.size());
        }
        Set<Question> setQuestions=new HashSet<>();
        while (setQuestions.size()<amount){
            setQuestions.add(questionService.getRandom());
        }
        return setQuestions;

    }
}
