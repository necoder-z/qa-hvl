package hvl.qa.web.service.impl;

import hvl.qa.web.entity.Vote;
import hvl.qa.web.repository.VoteRepository;
import hvl.qa.web.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Vote addVote(Vote tag) {
        Vote savedTag = voteRepository.saveAndFlush(tag);

        return savedTag;
    }

    @Override
    public void delete(long id) {
        voteRepository.delete(id);
    }

    @Override
    public Vote getById(Long id) {
        return voteRepository.findById(id);
    }

    @Override
    public Vote editVote(Vote tag) {
        return voteRepository.saveAndFlush(tag);
    }

    @Override
    public List<Vote> getAll() {
        return voteRepository.findAll();
    }

}
