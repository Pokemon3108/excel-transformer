package by.daryazaleuskaya.pricetransformer.model;

import lombok.Getter;

@Getter
public enum Group {

    CAT_R5("R5"), CAT_R4("R4"), CAT_R7("R7"), CAT_45("45"), CAT_46("46"), CAT_47("47"), CAT_94("94");

    private final String name;

    Group(String name) {
        this.name = name;
    }
}
