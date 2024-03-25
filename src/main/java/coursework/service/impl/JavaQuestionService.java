package coursework.service.impl;

import coursework.entity.Question;
import coursework.exception.NotUniqueQuestionException;
import coursework.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();
    private final List<Question> questions = new ArrayList<>();

    @Override
    public Question add(Question question) {
        if (questions.contains(question)){
            throw new NotUniqueQuestionException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question,answer));
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }


    @Override
    public Question getRandom() {
        int ind = random.nextInt(questions.size());
        return questions.get(ind);
    }
    @Override
    public int size() {
        return questions.size();
    }
}
