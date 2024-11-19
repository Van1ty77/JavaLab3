package ru.yurtaev.power;

public class PowerCalculator {

    public static double power(String xStr, String yStr) {
        try {
            int x = Integer.parseInt(xStr);
            int y = Integer.parseInt(yStr);
            return Math.pow(x, y);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Введены некорректные числа.");
            return Double.NaN; // Возвращаем NaN при ошибке преобразования
        }
    }

    public static void run(String[] args) {
        if (args.length != 2) {
            System.err.println("Ошибка: Необходимо указать два аргумента (основание и показатель степени).");
            return;
        }

        double result = power(args[0], args[1]);

        if (!Double.isNaN(result)) {
            System.out.println(args[0] + " в степени " + args[1] + " = " + result);
        }
    }
}
