package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return x - b;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultSum = Calculator.sum(10);
        int resultMultiply = calculator.multiply(5);
        int resultMinus = Calculator.minus(3);
        int resultDivide = calculator.divide(20);
        int resultSumAllOperation = calculator.sumAllOperation(5);
        System.out.println(resultSum);
        System.out.println(resultMultiply);
        System.out.println(resultMinus);
        System.out.println(resultDivide);
        System.out.println(resultSumAllOperation);

    }
}