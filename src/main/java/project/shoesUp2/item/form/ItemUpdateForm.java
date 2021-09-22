package project.shoesUp2.item.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemUpdateForm {


    @NotBlank
    private String itemName; //상품명

    @NotNull //null을 허용하지 않는다.
    private String date; //출시일

    @NotNull //null을 허용하지 않는다.
    private String releaseTime; //출시 시간


}
