package hvl.qa.web.controller.api;

import hvl.qa.web.entity.Favorites;
import hvl.qa.web.entity.User;
import hvl.qa.web.model.AjaxResponseBody;
import hvl.qa.web.model.FavModel;
import hvl.qa.web.service.*;
import hvl.qa.web.service.*;
import hvl.qa.web.util.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FavoritesController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${jwt.secret}")
    private String key;

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    TagService tagService;

    @Autowired
    FavoritesService favoritesService;

    @RequestMapping(value = "/favPost", method = RequestMethod.POST)
    public AjaxResponseBody favPost(@RequestBody FavModel data) {
        logger.info("Fav Question : {}", data.getPostId());
        AjaxResponseBody result = new AjaxResponseBody();

        AuthService authService = new AuthService(data.getToken(), key);

        if (authService.getUserName() == null) {
            result.setCode("404");
            result.setMsg(authService.getMessage());
            return result;
        }

        //OK, we can trust this JWT
        String userName = authService.getUserName();

        User currentUser = userService.getByUsername(userName);

        Favorites fav = new Favorites(currentUser, data.getFavType(), data.getPostId());

        favoritesService.addFavorites(fav);

        result.setCode("201");
        return result;
    }

    @RequestMapping(value = "/favPosts", method = RequestMethod.GET)
    public ResponseEntity<?> getFav(@RequestBody FavModel data) {
        logger.info("Fetching favorites with type {} for current user", data.getFavType());

        AuthService authService = new AuthService(data.getToken(), key);

        if (authService.getUserName() == null) {
            new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        String userName = authService.getUserName();

        User currentUser = userService.getByUsername(userName);

        List<Favorites> favs = favoritesService.getAllByUserAndFavType(currentUser.getId(), data.getFavType().getId());

        return new ResponseEntity(favs, HttpStatus.OK);
    }


}
