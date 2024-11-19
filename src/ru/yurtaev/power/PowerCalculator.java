package ru.yurtaev.power;

import java.util.Scanner;

public class PowerCalculator {

    public static double power(String xStr, String yStr) {
        try {
            int x = Integer.parseInt(xStr);
            int y = Integer.parseInt(yStr);
            return Math.pow(x, y);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Введены некорректные числа.");
            return Double.NaN;
        }
    }

    public static void run(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите основание степени: ");
        String x = scanner.nextLine();

        System.out.print("Введите показатель степени: ");
        String y = scanner.nextLine();

        double result = power(x, y);

        if (!Double.isNaN(result)) {
            System.out.println(x + " в степени " + y + " = " + result);
        }

        scanner.close();
    }
}