package coursework;

import coursework.entity.Question;
import coursework.service.QuestionService;
import coursework.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class JavaQuestionServiceTest {
    QuestionService out = new JavaQuestionService();

    private final Question question = new Question("q1", "a1");
    private final Question question2 = new Question("q2", "a2");
    private final Question question3 = new Question("q3", "a3");

    @Test
    public void addTest() {


        assertEquals(out.add("q1", "a1"), question);
        out.add(question2);
        assertTrue(out.getAll().contains(question2));
        assertFalse(out.getAll().contains(question3));
    }

    @Test
    public void removeTest() {
        out.add(question);
        assertTrue(out.remove(question)
                .equals(question));
    }

}
