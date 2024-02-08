package by.daryazaleuskaya.pricetransformer.service.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryConditionTest {

    @Test
    void checkWomanProduct() {
        String productName = "АНОРАК ЖЕНСКИЙ";
        assertTrue(CategoryCondition.isWoman(productName));
    }

}