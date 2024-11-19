package ru.yurtaev.geometry;

// Создаем исключение для некорректного ввода
public class InvalidShapeInputException extends RuntimeException {
    public InvalidShapeInputException(String message) {
        super(message);
    }
}
