/**
 * Phase 1: Core Java Fundamentals
 * Topic: Variables, Data Types, Control Flow, and Loops
 */
public class Basics {

    public static void main(String[] args) {
        System.out.println("=== Phase 1: Core Java Fundamentals ===");

        // Primitive Data Types
        int age = 22;
        double price = 99.99;
        char grade = 'A';
        boolean isJavaFun = true;

        System.out.println("Age: " + age + ", Price: $" + price + ", Grade: " + grade + ", Active: " + isJavaFun);

        // Control Flow: If-Else
        if (age >= 18) {
            System.out.println("Status: Eligible to Code!");
        } else {
            System.out.println("Status: Student Developer");
        }

        // Loops: For Loop & While Loop
        System.out.print("Counting 1 to 5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Switch Expression
        String day = "MONDAY";
        switch (day) {
            case "MONDAY" -> System.out.println("Day 1: Start DSA Grind");
            case "FRIDAY" -> System.out.println("Day 5: Review Patterns");
            default -> System.out.println("Keep Practicing!");
        }
    }
}
