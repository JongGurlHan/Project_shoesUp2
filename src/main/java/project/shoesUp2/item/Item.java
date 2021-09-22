package project.shoesUp2.item;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Item {
    private Long id; //상품 아이디

    @NotBlank(message = "공백x") //빈값 + 공백만 있는 경우를 허용하지 않는다.
    private String itemName; //상품명
    private Integer price; //상품가격

    @NotNull //null을 허용하지 않는다.
    private String date; //출시일

    @NotNull //null을 허용하지 않는다.
    private String releaseTime; //출시 시간

    private String imgUrl; // 이미지url

    private ItemType itemType; //상품종류
    private String brand; // 브랜드 종류

    public Item(){

    }
    public Item(String itemName, String date) {
        this.itemName = itemName;
        this.date = date;
    }

    public Item(String itemName, String date, String imgUrl, String releaseTime) {
        this.itemName = itemName;
        this.date = date;
        this.imgUrl = imgUrl;
        this.releaseTime = releaseTime;
    }




}
