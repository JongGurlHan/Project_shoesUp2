package project.shoesUp2.item.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ItemSaveForm {


    @NotBlank
    private String itemName; //상품명

    @NotBlank //null을 허용하지 않는다.
    private String date; //출시일

    @NotBlank//null을 허용하지 않는다.
    private String releaseTime; //출시 시간


}
