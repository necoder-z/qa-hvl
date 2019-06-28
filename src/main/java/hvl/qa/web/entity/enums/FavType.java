package hvl.qa.web.entity.enums;

public enum FavType {
    Question(0),
    Answer(1),
    Tag(2),
    User(3);

    private Integer id;

    public Integer getId() {
        return id;
    }

    FavType(Integer id) {
        this.id = id;
    }
}
