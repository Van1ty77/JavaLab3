package ru.yurtaev.tree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BinaryTree {

    private static int getValidInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите корректное целое число.");
                scanner.nextLine(); // Очищаем буфер ввода
            }
        }
    }

    private static int getValidInteger(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int value = getValidInteger(scanner, prompt);
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("Ошибка: введите число в диапазоне от " + min + " до " + max + ".");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = new Node();

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить значение");
            System.out.println("2. Удалить значение");
            System.out.println("3. Проверить существование значения");
            System.out.println("4. Вывести дерево");
            System.out.println("5. Выйти");

            int choice = getValidInteger(scanner, "Введите номер действия: ", 1, 5);

            switch (choice) {
                case 1 -> {
                    int value = getValidInteger(scanner, "Введите значение для добавления: ");
                    root.addValue(value);
                    System.out.println("Значение " + value + " добавлено.");
                }
                case 2 -> {
                    int value = getValidInteger(scanner, "Введите значение для удаления: ");
                    root.removeValue(value);
                    System.out.println("Значение " + value + " удалено (если было в дереве).");
                }
                case 3 -> {
                    int value = getValidInteger(scanner, "Введите значение для проверки: ");
                    boolean exists = root.containsValue(value);
                    System.out.println("Значение " + value + (exists ? " существует" : " не найдено") + " в дереве.");
                }
                case 4 -> {
                    System.out.println("Текущее дерево (левосторонний обход):");
                    System.out.println(root.toString().trim());
                }
                case 5 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
            }
        }
    }
}
