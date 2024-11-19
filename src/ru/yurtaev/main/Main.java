package ru.yurtaev.main;

import ru.yurtaev.geometry.*;
import ru.yurtaev.tree.BinaryTree;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Демонстрация работы с BinaryTree
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Операции с бинарным деревом");
        BinaryTree.main(args);  // Запуск меню операций с бинарным деревом

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

        // Демонстрация работы с LengthMeasurable
        System.out.println("\nДемонстрация LengthMeasurable");

        // Создание списка объектов LengthMeasurable
        List<LengthMeasurable> shapes = new ArrayList<>();
        shapes.add(new ClosedBrokenLine());

        // Расчет общей длины
        double totalLength = LengthCalculator.calculateTotalLength(shapes);
        System.out.println("Общая длина всех LengthMeasurable фигур: " + totalLength);
    }
}
