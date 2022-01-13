package br.com.app.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {

    // 1.000,00 -> 1000.00
    public static BigDecimal conveter(String value){
        if(value == null){
            return null;
        }
        value = value.replace(".","").replace(",",".");
        return new BigDecimal(value);
    }
}
