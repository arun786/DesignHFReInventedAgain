package com.arun.designpattern.decoratorpattern;

/**
 * @author arun on 9/25/20
 */


public class ShapeDecorator {

    public static void main(String[] args) {
        Shape circle = new Circle(10);
        System.out.println(circle.info());

        //i want a circle of red color
        Shape coloredCircle = new ColoredCircle(circle, "red");
        System.out.println(coloredCircle.info());
    }
}


//component
interface Shape {
    String info();
}

//concrete component
class Circle implements Shape {
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public String info() {
        return "A circle of radius of " + radius;
    }
}


//decorator
abstract class CircleDecorator implements Shape {
    //composition
    protected Shape shape;

    CircleDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public String info() {
        return shape.info();
    }
}

//decorator concrete implementation
class ColoredCircle extends CircleDecorator {
    private final String color;

    public ColoredCircle(Shape shape, String color) {
        super(shape);
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " having color " + color;
    }
}
