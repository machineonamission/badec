package com.blueair.core.util;

public interface JsonSerializer<T> {
    T fromJson(String str) throws Exception;

    String toJson(T t);
}
