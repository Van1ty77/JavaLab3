package ru.yurtaev.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Point implements Cloneable {
    private double x;  // Координата X
    private double y;  // Координата Y

    // Конструктор для инициализации координат X и Y
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Метод для текстового представления точки
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Методы для получения координат
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Метод для смещения точки
    public void shift(double shiftX, double shiftY) {
        this.x += shiftX;
        this.y += shiftY;
    }

    // Метод для вычисления расстояния между текущей точкой и другой точкой
    public double distanceTo(Point other) {
        double dx = other.getX() - this.x;
        double dy = other.getY() - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Метод для создания нескольких точек по введенным координатам
    public static List<Point> createPoints(String input) {
        List<Point> points = new ArrayList<>();
        String[] coords = input.split("\\s+"); // Разделение по пробелам
        for (int i = 0; i < coords.length; i += 2) {
            if (i + 1 < coords.length) {
                try {
                    double x = Double.parseDouble(coords[i]);
                    double y = Double.parseDouble(coords[i + 1]);
                    points.add(new Point(x, y));  // Создание новой точки
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод координат: " + coords[i] + ", " + coords[i + 1]);
                }
            }
        }
        return points;  // Возвращаем список созданных точек
    }

    // Переопределенный метод clone() для клонирования объекта ru.yurtaev.geometry.Point
    @Override
    public Point clone() {
        try {
            return (Point) super.clone();  // Создаем и возвращаем копию объекта
        } catch (CloneNotSupportedException e) {
            // В случае ошибки (хотя в данном случае она не должна произойти, так как класс реализует Cloneable)
            throw new AssertionError("Клонирование не поддерживается", e);
        }
    }

    // Метод для работы с пользовательским вводом
    public static void run(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод координат для нескольких точек
        System.out.print("Введите координаты точек (в формате X Y через пробел): ");
        String input = scanner.nextLine();
        List<Point> createdPoints = createPoints(input); // Создание точек из введенных данных

        // Список для хранения точек
        List<Point> points = new ArrayList<>(createdPoints); // Добавляем все созданные точки в список

        // Вывод всех точек
        System.out.println("\nСписок всех точек:");
        for (int i = 0; i < points.size(); i++) {
            System.out.println("Точка " + (i + 1) + ": " + points.get(i));
        }

        // Пример клонирования первой точки
        Point originalPoint = points.get(0);
        Point clonedPoint = originalPoint.clone();
        System.out.println("\nОригинальная точка: " + originalPoint);
        System.out.println("Клонированная точка: " + clonedPoint);
    }
}
