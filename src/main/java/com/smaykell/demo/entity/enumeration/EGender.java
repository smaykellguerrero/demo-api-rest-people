package com.smaykell.demo.entity.enumeration;

import java.util.Optional;
import java.util.stream.Stream;

public enum EGender implements Enumeration {

    MALE("M"), FEMALE("F"), ERROR("E");

    private final String code;

    private EGender(String code) {
        this.code = code;
    }

    public static Optional<EGender> valueOfCode(String code) {
        return Stream.of(EGender.values()).filter(t -> t.code.equals(code)).findFirst();
    }

    @Override
    public String getCode() {
        return code;
    }
}