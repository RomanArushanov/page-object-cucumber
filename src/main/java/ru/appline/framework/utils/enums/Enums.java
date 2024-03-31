package ru.appline.framework.utils.enums;

public enum Enums {
    DEPARTURE_CITY("Город выбытия"),
    ARRIVAL_CITY("Город прибытия"),
    DEPARTURE_DATE("Дата отправления"),
    RETURN_DATE("Дата возвращения");

    private final String enumsValue;

    Enums(String value) {
        this.enumsValue = value;
    }

    public String getValue() {
        return enumsValue;
    }
}
