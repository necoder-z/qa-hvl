package hvl.qa.web.service;

import hvl.qa.web.entity.Answer;
import hvl.qa.web.entity.User;

import java.util.List;

public interface AnswerService {
    Answer addAnswer(Answer answer);
    void delete(long id);
    List<Answer> getByUser(User user);
    Answer getById(Long id);
    Answer editAnswer(Answer answer);
    List<Answer> getAll();
}
