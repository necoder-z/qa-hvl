package hvl.qa.web.service;

import hvl.qa.web.entity.Question;
import hvl.qa.web.entity.Tag;
import hvl.qa.web.entity.User;
import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);
    void delete(long id);
    List<Question> getByUser(User user);
    List<Question> getByTag(Tag tag);
    Question getById(Long id);
    Question editQuestion(Question question);
    List<Question> getAll();
}