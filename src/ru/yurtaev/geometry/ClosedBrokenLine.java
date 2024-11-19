package ru.yurtaev.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClosedBrokenLine extends BrokenLine {
    public ClosedBrokenLine() {
        super();
    }

    public ClosedBrokenLine(List<Point> points) {
        super(points);
        ensureClosed();
    }

    @Override
    public double getLength() {
        double length = super.getLength();

        // Если есть хотя бы две точки, добавляем расстояние между последней и первой
        List<Point> points = getPoints();
        if (points.size() > 1) {
            Point first = points.get(0);
            Point last = points.get(points.size() - 1);
            length += calculateDistance(first, last);
        }

        return length;
    }

    // Метод, чтобы убедиться, что ломаная замкнута
    private void ensureClosed() {
        List<Point> points = getPoints();
        if (!points.isEmpty() && !points.get(0).equals(points.get(points.size() - 1))) {
            points.add(points.get(0)); // Замыкаем линию, добавляя начальную точку в конец
        }
    }

    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите корректное число.");
                scanner.nextLine();
            }
        }
    }

    private static int getValidInteger(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Ошибка: введите число в диапазоне от " + min + " до " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите корректное целое число.");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void addPoints(Point[] newPoints) {
        super.addPoints(newPoints);
        ensureClosed(); // После добавления новых точек проверяем замыкание
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Point> points = new ArrayList<>();
        ClosedBrokenLine closedLine = new ClosedBrokenLine();

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить точку");
            System.out.println("2. Посмотреть точки");
            System.out.println("3. Посчитать длину замкнутой ломаной");
            System.out.println("4. Выйти");

            int choice = getValidInteger(scanner, "Введите номер действия: ", 1, 4);

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите координату X: ");
                    double x = getValidDouble(scanner);
                    System.out.print("Введите координату Y: ");
                    double y = getValidDouble(scanner);

                    Point newPoint = new Point(x, y);
                    closedLine.addPoints(new Point[]{newPoint});
                    System.out.println("Точка добавлена: " + newPoint);
                }
                case 2 -> {
                    System.out.println("Точки замкнутой ломаной:");
                    for (Point point : closedLine.getPoints()) {
                        System.out.println(point);
                    }
                }
                case 3 -> {
                    System.out.println("Длина замкнутой ломаной: " + closedLine.getLength());
                }
                case 4 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
            }
        }
    }
}
