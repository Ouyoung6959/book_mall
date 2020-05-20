package com.hnit.bmall.cart.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ouyoung
 * @date 2020/5/20
 **/
@Controller
public class cartController {

    @RequestMapping("addToCart")
    public String addToCart(String bid ,Integer quantity){

        String memberId ="";
        if (StringUtils.isBlank(memberId)){

        }else {
            
        }

        return "redirect:/success.html";
    }

//    @RequestMapping("cartSuccess")
//    public String cartSuccess(){
//        return "";
//    }
}
