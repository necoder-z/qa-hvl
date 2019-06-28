package hvl.qa.web.controller.api;

import com.fasterxml.jackson.annotation.JsonView;
import hvl.qa.web.entity.*;
import hvl.qa.web.entity.Answer;
import hvl.qa.web.entity.Question;
import hvl.qa.web.entity.User;
import hvl.qa.web.entity.Vote;
import hvl.qa.web.entity.enums.VoteMark;
import hvl.qa.web.jsonview.Views;
import hvl.qa.web.model.AjaxResponseBody;
import hvl.qa.web.model.VoteModel;
import hvl.qa.web.service.*;
import hvl.qa.web.service.AnswerService;
import hvl.qa.web.service.QuestionService;
import hvl.qa.web.service.UserService;
import hvl.qa.web.service.VoteService;
import hvl.qa.web.util.*;
import hvl.qa.web.util.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class VoteController {
    public static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Value("${jwt.secret}")
    private String key;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    UserService userService;

    @Autowired
    VoteService voteService;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public AjaxResponseBody createVote(@RequestBody VoteModel data, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Vote : {}", data);
        AjaxResponseBody result = new AjaxResponseBody();

        AuthService authService = new AuthService(data.getToken(), key);

        if (authService.getUserName() == null) {
            result.setCode("404");
            result.setMsg(authService.getMessage());
            return result;
        }

        //OK, we can trust this JWT
        String userName = authService.getUserName();

        User user = userService.getByUsername(userName);
        Question question = questionService.getById(data.getQuestion_id());
        Answer answer = answerService.getById(data.getAnswer_id());

        VoteMark mark = VoteMark.DOWN;
        if (Objects.equals(data.getMark(), "UP")) {
            mark = VoteMark.UP;
        }

        User author = user;

        if (question != null) {
            if (Objects.equals(user.getUsername(), question.getUser().getUsername())) {
                user = question.getUser();
            }

            author = question.getUser();
            if (mark == VoteMark.DOWN) {
                author.setPopular(author.getPopular() - 2);
            } else {
                author.setPopular(author.getPopular() + 5);
            }

        } else if (answer != null) {
            if (Objects.equals(user.getUsername(), answer.getQuestion().getUser().getUsername())) {
                user = answer.getQuestion().getUser();
            }

            author = answer.getUser();
            if (mark == VoteMark.DOWN) {
                author.setPopular(author.getPopular() - 2);
            } else {
                author.setPopular(author.getPopular() + 10);
            }
        }

        if (author != user) {
            userService.editUser(author);
        }

        Vote vote = new Vote(null, question, answer, user, mark);
        vote = voteService.addVote(vote);

        result.setCode("201");
        result.setMsg(Long.toString(vote.getId()));

        return result;
    }



}
