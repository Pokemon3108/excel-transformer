package by.daryazaleuskaya.pricetransformer.model;

import lombok.Getter;

@Getter
public enum Category {

    WOMAN_LIFE("Женский life", Group.CAT_45),
    WOMAN_SPORT("Женский sport", Group.CAT_45),
    WOMAN_HOME("Женский home", Group.CAT_46),
    WOMAN_UNDERWEAR("Женское белье", Group.CAT_46),
    WOMAN_TERMO("Термо женское", Group.CAT_46),
    WOMAN_BEACH("Женский пляж", Group.CAT_46),
    WOMAN_SOCKS("Носки женские", Group.CAT_47),

    MAN_LIFE("Мужской life", Group.CAT_45),
    MAN_HOME("Мужской home", Group.CAT_46),
    MAN_UNDERWEAR("Мужское белье", Group.CAT_46),
    MAN_TERMO("Термо мужское", Group.CAT_46),
    MAN_BEACH("Мужской пляж", Group.CAT_46),
    MAN_SOCKS("Носки женские", Group.CAT_47),
    UNISEX_SOCKS("Носки унисекс", Group.CAT_47),

    GIRL_LIFE("Девочка life", Group.CAT_R5),
    BOY_LIFE("Мальчик life", Group.CAT_R5),
    GIRL_HOME("Девочка home", Group.CAT_R4),
    BOY_HOME("Мальчик home", Group.CAT_R4),
    GIRL_UNDERWEAR("Девочка белье", Group.CAT_R4),
    BOY_UNDERWEAR("Мальчик белье", Group.CAT_R4),
    GIRL_TERMO("Девочка термо", Group.CAT_R4),
    BOY_TERMO("Мальчик термо", Group.CAT_R4),
    GIRL_BEACH("Девочка пляж", Group.CAT_R4),
    BOY_BEACH("Мальчик пляж", Group.CAT_R4),
    CHILD_SOCKS("Носки детские", Group.CAT_R7),
    CHILD_TIGHTS("Колготки детские", Group.CAT_R7),

    ACCESSORIES("Аксессуары", Group.CAT_94),
    PACKAGE("Упаковка", Group.CAT_94);

    private final String name;
    private final Group group;

    Category(String name, Group group) {
        this.name = name;
        this.group = group;
    }
}
