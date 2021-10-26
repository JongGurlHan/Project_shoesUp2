package project.shoesUp2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.shoesUp2.item.Item;
import project.shoesUp2.item.ItemRepository;
import project.shoesUp2.item.ItemRepository2;
import project.shoesUp2.item.form.ItemSaveForm;

import java.util.List;
//아이템의 등록,조회,수정 하는 컨트롤러

@Slf4j
@RequestMapping("/items/items_newbalance")
@Controller
//@RequiredArgsConstructor
public class ItemController2 {

    private final ItemRepository2 itemRepository2;

    // ItemController가 스프링 bean에 등록 됨으로써 생성자 주입으로 ItemRepository가 주입된다.
    // 스프링에선 생성자가 딱 하나만 있다면 @Autowired 생략가능
    // 롬복의 @RequiredArgsConstructor를 쓰면 생성자 자동만들어서 아래 전체 생략가능
    @Autowired
    public ItemController2(ItemRepository2 itemRepository2) {
        this.itemRepository2 = itemRepository2;
    }

    //메인페이지 - 전체 조회
    @GetMapping
    public String items2(Model model){
        List<Item> items2 = itemRepository2.findAll();
        model.addAttribute("items2", items2);
        return "items/items_newbalance";
    }

    //각 상품별 조회
    @GetMapping({"/{itemId}"})
    public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository2.findById(itemId);
        model.addAttribute("item", item);
        return "items/item";
    }




}
