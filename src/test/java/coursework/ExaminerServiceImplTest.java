package coursework;

import coursework.entity.Question;
import coursework.service.QuestionService;
import coursework.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl out;

    private static final Question QUESTION1 = new Question("q1", "a1");
    private static final Question QUESTION2 = new Question("q2", "a2");
    private static final Question QUESTION3 = new Question("q3", "a3");
    private static final Question QUESTION4 = new Question("q4", "a4");
    private static final Question QUESTION5 = new Question("q5", "a5");




    @Test
    public void getQuestionTestOnThrow(){
        when(questionService.size()).thenReturn(2);
        assertThrows(IllegalArgumentException.class, ()->out.getQuestion(3));
    }

    @Test
    public void getQuestionTest(){
        when(questionService.getRandom())
                .thenReturn(QUESTION1, QUESTION2,QUESTION3,QUESTION4,QUESTION5);
        when(questionService.size()).thenReturn(10);
        assertEquals(out.getQuestion(5).size(),5);
    }




}
