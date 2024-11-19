package ru.yurtaev.geometry;

import java.util.Scanner;

// Абстрактный базовый класс для всех фигур
abstract class AbstractShape {
    public abstract double getArea();
}

// Класс для работы с фигурами
public class ShapeCreator {
    private static final Scanner scanner = new Scanner(System.in);

    private AbstractShape shape;

    // Метод для создания круга с проверкой ввода
    public Circle createCircle() {
        try {
            double x = getValidDouble("Введите координаты центра круга (x): ");
            double y = getValidDouble("Введите координаты центра круга (y): ");
            double radius = getValidDouble("Введите радиус круга: ");
            return new Circle(new Point(x, y), radius);
        } catch (InvalidShapeInputException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Метод для создания квадрата с проверкой ввода
    public Square createSquare() {
        try {
            double x = getValidDouble("Введите координаты верхнего левого угла квадрата (x): ");
            double y = getValidDouble("Введите координаты верхнего левого угла квадрата (y): ");
            double side = getValidDouble("Введите длину стороны квадрата: ");
            return new Square(new Point(x, y), side);
        } catch (InvalidShapeInputException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Метод для создания прямоугольника с проверкой ввода
    public Rectangle createRectangle() {
        try {
            double x = getValidDouble("Введите координаты верхнего левого угла прямоугольника (x): ");
            double y = getValidDouble("Введите координаты верхнего левого угла прямоугольника (y): ");
            double width = getValidDouble("Введите ширину прямоугольника: ");
            double height = getValidDouble("Введите высоту прямоугольника: ");
            return new Rectangle(new Point(x, y), width, height);
        } catch (InvalidShapeInputException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Метод для создания треугольника с проверкой ввода
    public Triangle createTriangle() {
        try {
            double x1 = getValidDouble("Введите координаты первой вершины треугольника (x1): ");
            double y1 = getValidDouble("Введите координаты первой вершины треугольника (y1): ");
            double x2 = getValidDouble("Введите координаты второй вершины треугольника (x2): ");
            double y2 = getValidDouble("Введите координаты второй вершины треугольника (y2): ");
            double x3 = getValidDouble("Введите координаты третьей вершины треугольника (x3): ");
            double y3 = getValidDouble("Введите координаты третьей вершины треугольника (y3): ");
            return new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
        } catch (InvalidShapeInputException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Метод для получения действительного числа с проверкой
    private double getValidDouble(String prompt) {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = scanner.nextDouble();
                if (value <= 0) {
                    throw new InvalidShapeInputException("Значение должно быть положительным числом.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Неверный ввод. Пожалуйста, введите корректное число.");
                scanner.next(); // Очищаем неправильный ввод
            }
        }
        return value;
    }

    // Метод для вычисления площади фигуры
    public double getArea() {
        if (shape != null) {
            return shape.getArea();
        } else {
            System.out.println("Фигура не создана.");
            return -1;
        }
    }

    // Метод для вывода информации о фигуре
    public String getShapeInfo() {
        if (shape != null) {
            return shape.toString();
        } else {
            return "Фигура не создана.";
        }
    }

    // Метод для установки фигуры
    public void setShape(AbstractShape shape) {
        this.shape = shape;
    }

    // Метод для получения фигуры
    public AbstractShape getShape() {
        return shape;
    }
}
