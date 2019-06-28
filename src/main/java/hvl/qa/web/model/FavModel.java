package hvl.qa.web.model;

import hvl.qa.web.entity.enums.FavType;


public class FavModel {
    private FavType favType;
    private String token;
    private Integer postId;

    public FavModel(FavType favType, String token, Integer postId) {
        this.favType = favType;
        this.token = token;
        this.postId = postId;
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

    public FavModel() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
