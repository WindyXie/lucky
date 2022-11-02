package com.example;

/**
 * Hello world!
 *
 */
public class App {
    // App的field
    private static int nextId = 1;
    private String name;
    private double salary;
    private int id;
    public App(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public int getId() {
        return id;
    }
    public void setId() {
        id = nextId;
        nextId++;
    }
    public static int getNextId() {
        return nextId;
    }
    // 方法签名： raiseSalary(double byPercent)
    // 注意：返回类型不是方法签名的一部分
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

class Test {
    public static void main(String... args) {
        /**
         * Test 1: Methods can't modify numeric parameters
         */
        System.out.println("Testing ripleValue: ");
        double percent = 10;
        System.out.println("Before: percent = " + percent);
        tripleValue(percent);
        System.out.println("After: percent = " + percent);

        /**
         * Test 2: Methods cna change the state of object parameters
         */
        System.out.println("\nTesting tripleSalary:");
        App harry = new App("Harry", 50000);
        System.out.println("Before: salary=:" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        /**
         * Test 3: Methods can't attach new objects to object parameters
         */
        System.out.println("\nTesting swap:");
        App a = new App("Alice", 70000);
        App b = new App("Bob", 60000);
        System.out.println("Before a=" + a.getName());
        System.out.println("Before b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }
    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method: x = " + x);
    }
    public static void tripleSalary(App x) {
        x.raiseSalary(200);
        System.out.println("End of method: salary=" + x.getSalary());
    }
    public static void swap(App x, App y) {
        App temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }
}