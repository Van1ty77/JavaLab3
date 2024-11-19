package ru.yurtaev.geometry;

// Класс для прямоугольника
public class Rectangle extends AbstractShape {
    private final Point topLeft;
    private final double width;
    private final double height;

    public Rectangle(Point topLeft, double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new InvalidShapeInputException("Ширина и высота прямоугольника должны быть положительными числами.");
        }
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Прямоугольник с верхним левым углом в точке " + topLeft + " и размерами: ширина = " + width + ", высота = " + height;
    }
}
