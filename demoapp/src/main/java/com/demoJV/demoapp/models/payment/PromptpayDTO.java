package com.demoJV.demoapp.models.payment;

import lombok.Data;

@Data
public class PromptpayDTO {

    private int product_id;
    //supply phone
    private String id;
    //product price
    private int price;

    public int getProduct_Id() {
        return product_id;
    }
}
