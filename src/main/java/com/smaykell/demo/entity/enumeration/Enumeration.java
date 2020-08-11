package com.smaykell.demo.entity.enumeration;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface Enumeration {
    Supplier<? extends RuntimeException> invalidEnumerationValue = (Supplier<RuntimeException>) () -> new IllegalStateException(
            "No se pudo convertir el valor de enumeración");

    static <T extends Enumeration> Optional<T> valueOf(Class<T> enumType, String code) {
        return Stream.of(enumType.getEnumConstants())
                .filter(p -> p.toString().equalsIgnoreCase(code) || p.getCode().equals(code)).findFirst();
    }

    String getCode();
}