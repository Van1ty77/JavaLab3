package ru.yurtaev.geometry;

import java.util.Scanner;

// Создаем исключение для некорректного ввода
public class InvalidShapeInputException extends RuntimeException {
    public InvalidShapeInputException(String message) {
        super(message);
    }
}


