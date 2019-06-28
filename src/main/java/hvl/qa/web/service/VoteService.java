package hvl.qa.web.service;

import hvl.qa.web.entity.Vote;
import java.util.List;

public interface VoteService {
    Vote addVote(Vote vote);
    void delete(long id);
    Vote getById(Long id);
    Vote editVote(Vote vote);
    List<Vote> getAll();
}