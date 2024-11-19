package ru.yurtaev.geometry;

// Класс для круга
public class Circle extends AbstractShape {
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new InvalidShapeInputException("Радиус круга должен быть положительным числом.");
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Круг с центром в точке " + center + " и радиусом " + radius;
    }
}
