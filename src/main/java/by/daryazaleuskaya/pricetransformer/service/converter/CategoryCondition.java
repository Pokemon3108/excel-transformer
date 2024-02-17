package by.daryazaleuskaya.pricetransformer.service.converter;
import java.util.function.BiPredicate;

import static by.daryazaleuskaya.pricetransformer.service.utils.StringUtils.contains;

public class CategoryCondition {

    public static final BiPredicate<String, String> WOMAN_LIFE_CONDITION = (name, articleNumber) -> isWoman(name) && articleNumber.startsWith("1");
    public static final BiPredicate<String, String> WOMAN_SPORT_CONDITION = (name, articleNumber) -> isWoman(name) && articleNumber.startsWith("3");
    public static final BiPredicate<String, String> WOMAN_HOME_CONDITION = (name, articleNumber) ->
            isWoman(name) && articleNumber.startsWith("5") && !contains(name,"бюстгальтер") && !contains(name,"бюстье");
    public static final BiPredicate<String, String> WOMAN_UNDERWEAR_CONDITION = (name, articleNumber) ->
            isWoman(name) && (articleNumber.startsWith("4") || articleNumber.startsWith("5"))
                    && (contains(name, "трусы") || contains(name,"бюстгальтер") || contains(name,"бюстье")
                    || contains(name,"майка") || contains(name,"топ"));
    public static final BiPredicate<String, String> WOMAN_TERMO_CONDITION = (name, articleNumber) -> isWoman(name)
            && (articleNumber.startsWith("6") || articleNumber.startsWith("7"));
    public static final BiPredicate<String, String> WOMAN_BEACH_CONDITION = (name, articleNumber) -> isWoman(name) &&
            (contains(name, "купальник") || contains(name,"купальный костюм"));
    public static final BiPredicate<String, String> WOMAN_SOCKS_CONDITION = (name, articleNumber) -> isWoman(name)
            && (name.contains("носки женские") || articleNumber.startsWith("9"));

    public static final BiPredicate<String, String> MAN_LIFE_CONDITION = (name, articleNumber) -> isMan(name)
            && (articleNumber.startsWith("1") || articleNumber.startsWith("3")) && !contains(name,"носки мужские");
    public static final BiPredicate<String, String> MAN_HOME_CONDITION = (name, articleNumber) -> isMan(name) && articleNumber.startsWith("5");
    public static final BiPredicate<String, String> MAN_UNDERWEAR_CONDITION = (name, articleNumber) -> isMan(name) && articleNumber.startsWith("4");
    public static final BiPredicate<String, String> MAN_TERMO_CONDITION = (name, articleNumber) -> isMan(name)
            && (articleNumber.startsWith("6") || articleNumber.startsWith("7"));
    public static final BiPredicate<String, String> MAN_BEACH_CONDITION = (name, articleNumber) -> isMan(name)
            && (contains(name,"плавки") || contains(name,"трусы купальные"));
    public static final BiPredicate<String, String> MAN_SOCKS_CONDITION = (name, articleNumber) -> isMan(name) && contains(name,"носки мужские");

    public static final BiPredicate<String, String> UNISEX_SOCKS_CONDITION = (name, articleNumber) -> name.equalsIgnoreCase("носки");

    public static final BiPredicate<String, String> GIRL_HOME_CONDITION = (name, articleNumber) -> isGirl(name) && articleNumber.startsWith("5");
    public static final BiPredicate<String, String> GIRL_LIFE_CONDITION = (name, articleNumber) -> isGirl(name)
            && (articleNumber.startsWith("1") || articleNumber.startsWith("3") || articleNumber.startsWith("2"));
    public static final BiPredicate<String, String> GIRL_UNDERWEAR_CONDITION = (name, articleNumber) -> isGirl(name)
            && (contains(name,"плавки") || contains(name,"трусы"));
    public static final BiPredicate<String, String> GIRL_BEACH_CONDITION = (name, articleNumber) -> isGirl(name) && articleNumber.startsWith("7");
    public static final BiPredicate<String, String> GIRL_TERMO_CONDITION = (name, articleNumber) -> isGirl(name) && contains(name,"термо");

    public static final BiPredicate<String, String> BOY_HOME_CONDITION = (name, articleNumber) -> isBoy(name) && articleNumber.startsWith("5");
    public static final BiPredicate<String, String> BOY_LIFE_CONDITION = (name, articleNumber) -> isBoy(name) && (articleNumber.startsWith("1") || articleNumber.startsWith("3"));
    public static final BiPredicate<String, String> BOY_UNDERWEAR_CONDITION = (name, articleNumber) -> isBoy(name)
            && (contains(name,"плавки") || contains(name,"трусы"));
    public static final BiPredicate<String, String> BOY_BEACH_CONDITION = (name, articleNumber) -> isBoy(name) && articleNumber.startsWith("7");
    public static final BiPredicate<String, String> BOY_TERMO_CONDITION = (name, articleNumber) -> isBoy(name) && contains(name,"термо");

    public static final BiPredicate<String, String> CHILD_SOCKS_CONDITION = (name, articleNumber) -> contains(name,"носки детские");
    public static final BiPredicate<String, String> CHILD_TIGHTS_CONDITION = (name, articleNumber) -> contains(name,"колготки детские");

    public static final BiPredicate<String, String> ACCESSORIES_CONDITION = (name, articleNumber) -> contains(name,"резинки") || contains(name, "заколки");
    public static final BiPredicate<String, String> PACKAGE_CONDITION = (name, articleNumber) -> contains(name,"пакет") || contains(name, "коробка");

    static boolean isWoman(String name) {
        return contains(name, "женск");
    }

    static boolean isMan(String name) {
        return contains(name, "мужск");
    }

    static boolean isGirl(String name) {
        return contains(name, "девоч");
    }

    static boolean isBoy(String name) {
        return contains(name, "мальчик");
    }

}
