package ru.yurtaev.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Square extends AbstractShape {
    private Point topLeft; // Левый верхний угол
    private double sideLength; // Длина стороны

    // Конструктор с точкой и размером стороны
    public Square(Point topLeft, double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть положительной.");
        }
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    // Конструктор с координатами точки и размером стороны
    public Square(double x, double y, double sideLength) {
        this(new Point(x, y), sideLength);
    }

    // Геттеры и сеттеры
    public Point getTopLeft() {
        return topLeft;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть положительной.");
        }
        this.sideLength = sideLength;
    }

    // Преобразование квадрата в строку
    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }

    // Реализация метода getArea()
    @Override
    public double getArea() {
        return sideLength * sideLength;  // Площадь квадрата
    }

    // Метод получения ломаной, состоящей из углов квадрата
    public BrokenLine toBrokenLine() {
        List<Point> points = new ArrayList<>();
        points.add(topLeft);
        points.add(new Point(topLeft.getX() + sideLength, topLeft.getY()));
        points.add(new Point(topLeft.getX() + sideLength, topLeft.getY() - sideLength));
        points.add(new Point(topLeft.getX(), topLeft.getY() - sideLength));
        points.add(topLeft); // Замыкаем ломаную линию
        return new BrokenLine(points);
    }

    // Метод для безопасного ввода числа с проверкой
    private static double getValidDouble(Scanner scanner, String prompt) {
        double number;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                number = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите числовое значение.");
            }
        }
        return number;
    }

    // Основной метод для обработки логики
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Создание квадрата:");
        double x = getValidDouble(scanner, "Введите координату X верхнего левого угла: ");
        double y = getValidDouble(scanner, "Введите координату Y верхнего левого угла: ");
        double sideLength;
        while (true) {
            sideLength = getValidDouble(scanner, "Введите длину стороны квадрата: ");
            if (sideLength > 0) {
                break;
            } else {
                System.out.println("Длина стороны должна быть положительной.");
            }
        }

        // Создаём квадрат
        Square square = new Square(x, y, sideLength);
        System.out.println("Создан " + square);

        // Преобразуем квадрат в ломаную линию
        BrokenLine brokenLine = square.toBrokenLine();
        System.out.println("Ломаная линия, созданная из углов квадрата: " + brokenLine);

        // Выводим длину ломаной линии
        System.out.println("Длина ломаной линии: " + brokenLine.getLength());

        // Смещаем последнюю точку
        System.out.println("\nСмещение последней точки ломаной линии.");
        double shiftX = getValidDouble(scanner, "Введите смещение по X: ");
        double shiftY = getValidDouble(scanner, "Введите смещение по Y: ");
        brokenLine.shiftPoint(brokenLine.getPoints().size() - 1, shiftX, shiftY);

        System.out.println("Обновлённая ломаная линия: " + brokenLine);
        System.out.println("Обновлённая длина ломаной линии: " + brokenLine.getLength());

        scanner.close();
    }
}
