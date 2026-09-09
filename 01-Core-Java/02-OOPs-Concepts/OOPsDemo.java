/**
 * Phase 1: Object-Oriented Programming (OOP)
 * Covers: Encapsulation, Inheritance, Polymorphism, Abstraction
 */

// Abstraction via Interface
interface Drawable {
    void draw();
}

// Parent Class (Inheritance & Encapsulation)
abstract class Shape implements Drawable {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method
    public abstract double calculateArea();
}

// Child Class 1
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + getName() + " with radius " + radius);
    }
}

// Child Class 2
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + getName() + " of size " + width + "x" + height);
    }
}

public class OOPsDemo {
    public static void main(String[] args) {
        System.out.println("=== OOPs Demonstration ===");

        // Polymorphism: Holding child instances in parent reference
        Shape s1 = new Circle(5.0);
        Shape s2 = new Rectangle(4.0, 6.0);

        s1.draw();
        System.out.println("Area of " + s1.getName() + ": " + String.format("%.2f", s1.calculateArea()));

        s2.draw();
        System.out.println("Area of " + s2.getName() + ": " + s2.calculateArea());
    }
}
