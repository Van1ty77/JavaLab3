package ru.yurtaev.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BrokenLine implements LengthMeasurable {
    private final List<Point> points;  // Список точек, через которые проходит линия

    // Конструктор для создания ломаной без указания параметров
    public BrokenLine() {
        this.points = new ArrayList<>();  // Инициализируем пустой список точек
    }

    // Конструктор для создания ломаной с набором точек
    public BrokenLine(List<Point> points) {
        this.points = points;
    }

    // Метод для добавления массива точек в ломаную
    public void addPoints(Point[] newPoints) {
        Collections.addAll(points, newPoints);
    }

    // Метод для сдвига указанной точки ломаной линии
    public void shiftPoint(int index, double shiftX, double shiftY) {
        if (points.isEmpty()) {
            System.out.println("Невозможно сместить точку, так как ломаная линия пуста.");
            return;  // Выходим из метода, если ломаная линия пуста
        }
        if (index >= 0 && index < points.size()) {
            Point pointToShift = points.get(index);
            pointToShift.shift(shiftX, shiftY);  // Сдвигаем выбранную точку
        } else {
            System.out.println("Некорректный индекс для точки.");
        }
    }

    // Метод для вычисления длины ломаной линии
    @Override
    public double getLength() {
        double length = 0.0;
        for (int i = 1; i < points.size(); i++) {
            length += calculateDistance(points.get(i - 1), points.get(i));
        }
        return length;
    }

    // Метод для вычисления расстояния между двумя точками
    public double calculateDistance(Point p1, Point p2) {
        return p1.distanceTo(p2);  // Вызываем метод distanceTo у класса ru.yurtaev.geometry.Point
    }

    // Геттер для получения списка точек
    public List<Point> getPoints() {
        return points;
    }

    // Метод для текстового представления ломаной линии
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ломаная линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Метод для сравнения двух ломаных линий
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Если ссылки одинаковые
        if (obj == null || getClass() != obj.getClass()) return false;  // Если объекты разных классов
        BrokenLine other = (BrokenLine) obj;

        // Сравниваем списки точек
        return points.equals(other.points);
    }

    // Метод для получения корректного целого числа от пользователя
    private static int getValidInteger(Scanner scanner) {
        int number;
        while (true) {
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);  // Преобразуем строку в целое число
                if (number >= 0) {
                    break;
                } else {
                    System.out.println("Введите неотрицательное целое число.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целое число.");
            }
        }
        return number;
    }

    // Метод для получения корректного вещественного числа от пользователя
    private static double getValidDouble(Scanner scanner) {
        double number;
        while (true) {
            String input = scanner.nextLine();
            try {
                number = Double.parseDouble(input);  // Преобразуем строку в число
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите числовое значение.");
            }
        }
        return number;
    }

    // Метод для получения корректного целого числа в заданном диапазоне
    private static int getValidIntegerInRange(Scanner scanner, int max) {
        int number;
        while (true) {
            number = getValidInteger(scanner);
            if (number >= 0 && number <= max) {
                break;
            } else {
                System.out.println("Введите число в диапазоне от " + 0 + " до " + max + ".");
            }
        }
        return number;
    }

    // Основной метод для работы программы
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Point> allPoints = new ArrayList<>();  // Список всех точек
        List<LengthMeasurable> allLines = new ArrayList<>();    // Список всех ломаных линий

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Создать новые точки");
            System.out.println("2. Создать ломаную линию из существующих точек");
            System.out.println("3. Создать пустую ломаную линию");
            System.out.println("4. Добавить точки в существующую ломаную линию");
            System.out.println("5. Смещать точку существующей ломаной линии");
            System.out.println("6. Получить длину существующей ломаной линии");
            System.out.println("7. Просмотреть все точки");
            System.out.println("8. Просмотреть все ломаные линии");
            System.out.println("9. Сравнить две ломаные линии");
            System.out.println("10. Выход");

            int choice = getValidInteger(scanner);

            switch (choice) {
                case 1 -> {
                    // Создание новых точек
                    System.out.print("Введите координаты точек (в формате X Y через пробел): ");
                    String input = scanner.nextLine();
                    List<Point> createdPoints = Point.createPoints(input); // Создание точек из введенных данных
                    allPoints.addAll(createdPoints); // Добавляем все созданные точки в общий список
                    System.out.println("Создано точек: " + createdPoints.size());
                }
                case 2 -> {
                    // Создаем ломаную линию из существующих точек
                    if (allPoints.isEmpty()) {
                        System.out.println("Сначала создайте точки.");
                    } else {
                        System.out.println("Выберите точки для ломаной линии (введите индексы через пробел):");
                        for (int i = 0; i < allPoints.size(); i++) {
                            System.out.println(i + ": " + allPoints.get(i));
                        }
                        String inputLine = scanner.nextLine();
                        String[] indices = inputLine.split("\\s+"); // Разделение по пробелам
                        List<Point> linePoints = new ArrayList<>();
                        for (String index : indices) {
                            int idx = Integer.parseInt(index.trim());
                            if (idx >= 0 && idx < allPoints.size()) {
                                linePoints.add(allPoints.get(idx));
                            } else {
                                System.out.println("Некорректный индекс: " + index);
                            }
                        }
                        BrokenLine brokenLine = new BrokenLine(linePoints);
                        allLines.add(brokenLine);  // Добавляем новую ломаную линию
                        System.out.println("Создана новая ломаная линия: " + brokenLine);
                    }
                }
                case 3 -> {
                    // Создать пустую ломаную линию
                    BrokenLine emptyLine = new BrokenLine();  // Создание пустой ломаной линии
                    allLines.add(emptyLine);
                    System.out.println("Создана пустая ломаная линия: " + emptyLine);
                }
                case 4 -> {
                    // Добавление точек в существующую ломаную линию
                    if (allLines.isEmpty()) {
                        System.out.println("Сначала создайте ломаную линию.");
                    } else {
                        System.out.println("Выберите ломаную линию для добавления точек:");
                        for (int i = 0; i < allLines.size(); i++) {
                            System.out.println(i + ": " + allLines.get(i));
                        }
                        int lineIndex = getValidIntegerInRange(scanner, allLines.size() - 1);
                        BrokenLine line = (BrokenLine) allLines.get(lineIndex);
                        System.out.println("Введите координаты точек для добавления (в формате X Y через пробел): ");
                        String input = scanner.nextLine();
                        Point[] newPoints = Point.createPoints(input).toArray(new Point[0]);
                        line.addPoints(newPoints);
                        System.out.println("Точки добавлены в ломаную линию.");
                    }
                }
                case 5 -> {
                    // Смещение точки в ломаной линии
                    if (allLines.isEmpty()) {
                        System.out.println("Сначала создайте ломаную линию.");
                    } else {
                        System.out.println("Выберите ломаную линию:");
                        for (int i = 0; i < allLines.size(); i++) {
                            System.out.println(i + ": " + allLines.get(i));
                        }
                        int lineIndex = getValidIntegerInRange(scanner, allLines.size() - 1);
                        BrokenLine line = (BrokenLine) allLines.get(lineIndex);
                        System.out.print("Введите индекс точки для сдвига: ");
                        int pointIndex = getValidInteger(scanner);
                        System.out.print("Введите смещение по X: ");
                        double shiftX = getValidDouble(scanner);
                        System.out.print("Введите смещение по Y: ");
                        double shiftY = getValidDouble(scanner);
                        line.shiftPoint(pointIndex, shiftX, shiftY);
                    }
                }
                case 6 -> {
                    // Получение длины ломаной линии
                    if (allLines.isEmpty()) {
                        System.out.println("Сначала создайте ломаную линию.");
                    } else {
                        System.out.println("Выберите ломаную линию для вычисления длины:");
                        for (int i = 0; i < allLines.size(); i++) {
                            System.out.println(i + ": " + allLines.get(i));
                        }
                        int lineIndex = getValidIntegerInRange(scanner, allLines.size() - 1);
                        LengthMeasurable line = allLines.get(lineIndex);
                        System.out.println("Длина линии: " + line.getLength());
                    }
                }
                case 7 -> {
                    // Просмотр всех точек
                    System.out.println("Все точки:");
                    for (int i = 0; i < allPoints.size(); i++) {
                        System.out.println(i + ": " + allPoints.get(i));
                    }
                }
                case 8 -> {
                    // Просмотр всех ломаных линий
                    System.out.println("Все ломаные линии:");
                    for (int i = 0; i < allLines.size(); i++) {
                        System.out.println(i + ": " + allLines.get(i));
                    }
                }
                case 9 -> {
                    // Сравнение двух ломаных линий
                    if (allLines.size() < 2) {
                        System.out.println("Для сравнения нужно иметь хотя бы две ломаные линии.");
                    } else {
                        System.out.println("Выберите первую ломаную линию для сравнения:");
                        for (int i = 0; i < allLines.size(); i++) {
                            System.out.println(i + ": " + allLines.get(i));
                        }
                        int lineIndex1 = getValidIntegerInRange(scanner, allLines.size() - 1);
                        BrokenLine line1 = (BrokenLine) allLines.get(lineIndex1);

                        System.out.println("Выберите вторую ломаную линию для сравнения:");
                        int lineIndex2 = getValidIntegerInRange(scanner, allLines.size() - 1);
                        BrokenLine line2 = (BrokenLine) allLines.get(lineIndex2);

                        if (line1.equals(line2)) {
                            System.out.println("Ломаные линии одинаковые.");
                        } else {
                            System.out.println("Ломаные линии разные.");
                        }
                    }
                }
                case 10 -> {
                    // Выход из программы
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Некорректный выбор.");
            }
        }
    }
}
