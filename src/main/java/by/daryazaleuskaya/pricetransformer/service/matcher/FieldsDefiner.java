package by.daryazaleuskaya.pricetransformer.service.matcher;


import by.daryazaleuskaya.pricetransformer.model.Category;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiPredicate;

import static by.daryazaleuskaya.pricetransformer.model.Category.ACCESSORIES;
import static by.daryazaleuskaya.pricetransformer.model.Category.BOY_BEACH;
import static by.daryazaleuskaya.pricetransformer.model.Category.BOY_HOME;
import static by.daryazaleuskaya.pricetransformer.model.Category.BOY_LIFE;
import static by.daryazaleuskaya.pricetransformer.model.Category.BOY_TERMO;
import static by.daryazaleuskaya.pricetransformer.model.Category.BOY_UNDERWEAR;
import static by.daryazaleuskaya.pricetransformer.model.Category.CHILD_SOCKS;
import static by.daryazaleuskaya.pricetransformer.model.Category.CHILD_TIGHTS;
import static by.daryazaleuskaya.pricetransformer.model.Category.GIRL_BEACH;
import static by.daryazaleuskaya.pricetransformer.model.Category.GIRL_HOME;
import static by.daryazaleuskaya.pricetransformer.model.Category.GIRL_LIFE;
import static by.daryazaleuskaya.pricetransformer.model.Category.GIRL_TERMO;
import static by.daryazaleuskaya.pricetransformer.model.Category.GIRL_UNDERWEAR;
import static by.daryazaleuskaya.pricetransformer.model.Category.MAN_BEACH;
import static by.daryazaleuskaya.pricetransformer.model.Category.MAN_HOME;
import static by.daryazaleuskaya.pricetransformer.model.Category.MAN_LIFE;
import static by.daryazaleuskaya.pricetransformer.model.Category.MAN_SOCKS;
import static by.daryazaleuskaya.pricetransformer.model.Category.MAN_TERMO;
import static by.daryazaleuskaya.pricetransformer.model.Category.MAN_UNDERWEAR;
import static by.daryazaleuskaya.pricetransformer.model.Category.PACKAGE;
import static by.daryazaleuskaya.pricetransformer.model.Category.UNISEX_SOCKS;
import static by.daryazaleuskaya.pricetransformer.model.Category.WOMAN_BEACH;
import static by.daryazaleuskaya.pricetransformer.model.Category.WOMAN_HOME;
import static by.daryazaleuskaya.pricetransformer.model.Category.WOMAN_LIFE;
import static by.daryazaleuskaya.pricetransformer.model.Category.WOMAN_SOCKS;
import static by.daryazaleuskaya.pricetransformer.model.Category.WOMAN_SPORT;
import static by.daryazaleuskaya.pricetransformer.model.Category.WOMAN_TERMO;
import static by.daryazaleuskaya.pricetransformer.model.Category.WOMAN_UNDERWEAR;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.ACCESSORIES_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.BOY_BEACH_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.BOY_HOME_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.BOY_LIFE_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.BOY_TERMO_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.BOY_UNDERWEAR_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.CHILD_SOCKS_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.CHILD_TIGHTS_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.GIRL_BEACH_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.GIRL_HOME_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.GIRL_LIFE_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.GIRL_TERMO_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.GIRL_UNDERWEAR_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.MAN_BEACH_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.MAN_HOME_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.MAN_LIFE_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.MAN_SOCKS_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.MAN_TERMO_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.MAN_UNDERWEAR_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.PACKAGE_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.UNISEX_SOCKS_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.WOMAN_BEACH_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.WOMAN_HOME_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.WOMAN_LIFE_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.WOMAN_SOCKS_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.WOMAN_SPORT_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.WOMAN_TERMO_CONDITION;
import static by.daryazaleuskaya.pricetransformer.service.converter.CategoryCondition.WOMAN_UNDERWEAR_CONDITION;

public class FieldsDefiner {

    private static final Map<Category, BiPredicate<String, String>> categoryToMatchingCondition = new EnumMap<>(Category.class);

    public FieldsDefiner() {
        categoryToMatchingCondition.put(WOMAN_LIFE, WOMAN_LIFE_CONDITION);
        categoryToMatchingCondition.put(WOMAN_SPORT, WOMAN_SPORT_CONDITION);
        categoryToMatchingCondition.put(WOMAN_HOME, WOMAN_HOME_CONDITION);
        categoryToMatchingCondition.put(WOMAN_UNDERWEAR, WOMAN_UNDERWEAR_CONDITION);
        categoryToMatchingCondition.put(WOMAN_TERMO, WOMAN_TERMO_CONDITION);
        categoryToMatchingCondition.put(WOMAN_BEACH, WOMAN_BEACH_CONDITION);
        categoryToMatchingCondition.put(WOMAN_SOCKS, WOMAN_SOCKS_CONDITION);
        categoryToMatchingCondition.put(MAN_LIFE, MAN_LIFE_CONDITION);
        categoryToMatchingCondition.put(MAN_HOME, MAN_HOME_CONDITION);
        categoryToMatchingCondition.put(MAN_UNDERWEAR, MAN_UNDERWEAR_CONDITION);
        categoryToMatchingCondition.put(MAN_TERMO, MAN_TERMO_CONDITION);
        categoryToMatchingCondition.put(MAN_BEACH, MAN_BEACH_CONDITION);
        categoryToMatchingCondition.put(MAN_SOCKS, MAN_SOCKS_CONDITION);
        categoryToMatchingCondition.put(UNISEX_SOCKS, UNISEX_SOCKS_CONDITION);
        categoryToMatchingCondition.put(GIRL_LIFE, GIRL_LIFE_CONDITION);
        categoryToMatchingCondition.put(BOY_LIFE, BOY_LIFE_CONDITION);
        categoryToMatchingCondition.put(GIRL_HOME, GIRL_HOME_CONDITION);
        categoryToMatchingCondition.put(BOY_HOME, BOY_HOME_CONDITION);
        categoryToMatchingCondition.put(GIRL_UNDERWEAR, GIRL_UNDERWEAR_CONDITION);
        categoryToMatchingCondition.put(BOY_UNDERWEAR, BOY_UNDERWEAR_CONDITION);
        categoryToMatchingCondition.put(GIRL_BEACH, GIRL_BEACH_CONDITION);
        categoryToMatchingCondition.put(BOY_BEACH, BOY_BEACH_CONDITION);
        categoryToMatchingCondition.put(GIRL_TERMO, GIRL_TERMO_CONDITION);
        categoryToMatchingCondition.put(BOY_TERMO, BOY_TERMO_CONDITION);
        categoryToMatchingCondition.put(CHILD_SOCKS, CHILD_SOCKS_CONDITION);
        categoryToMatchingCondition.put(CHILD_TIGHTS, CHILD_TIGHTS_CONDITION);
        categoryToMatchingCondition.put(ACCESSORIES, ACCESSORIES_CONDITION);
        categoryToMatchingCondition.put(PACKAGE, PACKAGE_CONDITION);
    }

    public String getCategory(String productName, String model) {
        for (var entry : categoryToMatchingCondition.entrySet()) {
            if (entry.getValue().test(productName, model)) {
                return entry.getKey().getName();
            }
        }
        return "Категория";
    }

    public String getGroup(String productName, String model) {
        for (var entry : categoryToMatchingCondition.entrySet()) {
            if (entry.getValue().test(productName, model)) {
                return entry.getKey().getGroup().getName();
            }
        }
        return "Группа";
    }

}