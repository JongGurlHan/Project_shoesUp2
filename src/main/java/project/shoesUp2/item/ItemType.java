package project.shoesUp2.item;

public enum ItemType {
    SHOES("신발"), SPORTSWEAR("스포츠웨어"), ETC("기타");

    private final String description; //필드값

    ItemType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
