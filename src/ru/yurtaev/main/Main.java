package ru.yurtaev.main;

import ru.yurtaev.geometry.*;
import ru.yurtaev.tree.BinaryTree;
import ru.yurtaev.power.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import static ru.yurtaev.geometry.BrokenLine.getValidInteger;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nВыберите задание:");
        System.out.println("1. Задание 1");
        System.out.println("2. Задание 2");
        System.out.println("3. Задание 3");
        System.out.println("4. Задание 4");
        System.out.println("5. Задание 5");
        System.out.println("6. Задание 6");
        System.out.println("7. Задание 7");
        System.out.println("8. Задание 8");
        System.out.println("9. Выход");

        int choice = getValidInteger(scanner);

        switch (choice) {
            case 1 -> {
                // Демонстрация работы с Square
                System.out.println("Операции с квадратом");
                Square.run1(args);
            }
            case 2 -> {
                // Демонстрация работы с BinaryTree
                System.out.println("Операции с бинарным деревом");
                BinaryTree.run2(args);  // Запуск меню операций с бинарным деревом
            }
            case 3 -> {
                // Демонстрация работы с ClosedBrokenLine
                System.out.println("Операции с замкнутой кривой");
                ClosedBrokenLine.run3(args);  // Запуск меню операций с бинарным деревом
            }
            case 4 -> {
                // Демонстрация работы с ShapeCreator
                System.out.println("\nОперации с Shape Creator");
                ShapeCreator shapeCreator = new ShapeCreator();

                // Создание и отображение круга
                Circle circle = shapeCreator.createCircle();
                if (circle != null) {
                    System.out.println("Созданная фигура: " + circle);
                    System.out.println("Площадь круга: " + circle.getArea());
                }

                // Создание и отображение прямоугольника
                Rectangle rectangle = shapeCreator.createRectangle();
                if (rectangle != null) {
                    System.out.println("Созданная фигура: " + rectangle);
                    System.out.println("Площадь прямоугольника: " + rectangle.getArea());
                }

                // Создание и отображение треугольника
                Triangle triangle = shapeCreator.createTriangle();
                if (triangle != null) {
                    System.out.println("Созданная фигура: " + triangle);
                    System.out.println("Площадь треугольника: " + triangle.getArea());
                }
            }
            case 5 -> {
                // Демонстрация работы с LengthMeasurable
                System.out.println("\nДемонстрация LengthMeasurable");

                // Создание списка объектов LengthMeasurable
                List<LengthMeasurable> shapes = new ArrayList<>();
                shapes.add(new ClosedBrokenLine());

                // Расчет общей длины
                double totalLength = LengthCalculator.calculateTotalLength(shapes);
                System.out.println("Общая длина всех LengthMeasurable фигур: " + totalLength);
            }
            case 6 -> {
                // Демонстрация работы с equal
                System.out.println("Операции с кривыми");
                BrokenLine.run(args);
            }
            case 7 -> {
                // Демонстрация работы с PowerCalculator
                System.out.println("Возведение в степень");
                PowerCalculator.run(args);  // Запуск меню операций с бинарным деревом
            }
            case 8 -> {
                // Демонстрация работы с clone
                System.out.println("Clone точки");
                Point.run(args);  // Запуск меню операций с бинарным деревом
            }
            case 9 -> {
                System.out.println("Выход из программы.");
            }
        }
    }
}
