package ac.ks.web.domain;

public enum BoardType {
    notice("공지게시판"),
    free("자유게시판");

    private String value;

    BoardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}