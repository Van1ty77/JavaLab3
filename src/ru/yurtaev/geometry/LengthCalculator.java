package ru.yurtaev.geometry;

import ru.yurtaev.geometry.LengthMeasurable;

import java.util.List;

public class LengthCalculator {
    public static double calculateTotalLength(List<LengthMeasurable> shapes) {
        double totalLength = 0;
        for (LengthMeasurable shape : shapes) {
            totalLength += shape.getLength();
        }
        return totalLength;
    }
}
