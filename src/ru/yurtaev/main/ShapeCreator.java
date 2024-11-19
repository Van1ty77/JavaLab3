package ru.yurtaev.main;

import ru.yurtaev.geometry.*;

import java.util.Scanner;

public class ShapeCreator {

    private static final Scanner scanner = new Scanner(System.in);

    public Circle createCircle() {
        try {
            double x = getValidDouble("Введите координату X центра круга: ");
            double y = getValidDouble("Введите координату Y центра круга: ");
            double radius = getValidDouble("Введите радиус круга: ");
            return new Circle(new Point(x, y), radius);
        } catch (InvalidShapeInputException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

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

    public Rectangle createRectangle() {
        try {
            double x = getValidDouble("Введите координату X верхнего левого угла прямоугольника: ");
            double y = getValidDouble("Введите координату Y верхнего левого угла прямоугольника: ");
            double width = getValidDouble("Введите ширину прямоугольника: ");
            double height = getValidDouble("Введите высоту прямоугольника: ");
            return new Rectangle(new Point(x, y), width, height);
        } catch (InvalidShapeInputException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Triangle createTriangle() {
        try {
            double x1 = getValidDouble("Введите координату X1 первой вершины треугольника: ");
            double y1 = getValidDouble("Введите координату Y1 первой вершины треугольника: ");
            double x2 = getValidDouble("Введите координату X2 второй вершины треугольника: ");
            double y2 = getValidDouble("Введите координату Y2 второй вершины треугольника: ");
            double x3 = getValidDouble("Введите координату X3 третьей вершины треугольника: ");
            double y3 = getValidDouble("Введите координату Y3 третьей вершины треугольника: ");
            return new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
        } catch (InvalidShapeInputException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

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
}
