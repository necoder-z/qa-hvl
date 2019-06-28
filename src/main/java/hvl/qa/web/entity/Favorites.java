package hvl.qa.web.entity;

import com.fasterxml.jackson.annotation.JsonView;
import hvl.qa.web.entity.enums.FavType;
import hvl.qa.web.jsonview.Views;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    @JsonView(Views.Public.class)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    @JsonView(Views.Public.class)
    private User user;

    @Column(name = "fav_type_id")
    @Enumerated(EnumType.STRING)
    @JsonView(Views.Public.class)
    private FavType favType;

    @Column(name = "post_id")
    @JsonView(Views.Public.class)
    private Integer postId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FavType getFavType() {
        return favType;
    }

    public void setFavType(FavType favType) {
        this.favType = favType;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Favorites(User user, FavType favType, Integer postId) {
        this.user = user;
        this.favType = favType;
        this.postId = postId;
    }
}
