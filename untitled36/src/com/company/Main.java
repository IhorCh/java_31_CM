package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        double epsilon = 0.001;
        System.out.println(dichotomyMethod(epsilon, 0, 1));
        //boundaries(epsilon);
    }

    private static double function(double x) {
        double f = Math.tan(x) - Math.pow(x, 2) - 0.5;
        //double f = (1 / (1 + Math.pow(x, 2))) - x;
        return f;
    }

    public static double dichotomyMethod(double epsilon, double a, double b) {
        double x = 0;
        double prevA = a;
        double prevB = b;
        int iteration = 0;

        boolean sign = false;
        if (function(a) > 0) {
            sign = true;
        }

        while ((b - a) > epsilon) {
            double c = (a + b) / 2;
            if ((function(a) * function(c)) < 0) {
                b = c;
            } else a = c;

            System.out.println("Iteration " + iteration);
            System.out.println("Left " + prevA);
            System.out.println("Center " + c);
            System.out.println("Right " + prevB + '\n');
            prevA = a;
            prevB = b;
            x = (a + b) / 2;
            iteration++;
        }
        double eps = 0.000001;
        System.out.println("Result \n" + x + '\n');
        System.out.println("Mismatch: " + mismatch(x) + '\n');

        System.out.println("Simple iterations with epsilon = " + eps);
        return iterations(x, eps, sign);
    }

    public static double iterations(double x, double eps, boolean sign) {
        double xprev = 0;
        int iteration = 0;
        if (sign) {
            do {
                xprev = x;
                x = x + function(x);

                System.out.println(x);
                iteration++;
            }
            while (Math.abs(xprev - x) > eps);
            System.out.println("iteration " + iteration);
            return x;
        } else {
            do {
                xprev = x;
                x = x - function(x);

                System.out.println(x);
                iteration++;
            }
            while (Math.abs(xprev - x) > eps);
            System.out.println("iteration " + iteration);
            return x;
        }
    }

    private static double mismatch(double x) {
        return Math.abs(function(x));
    }

    public static void boundaries(double epsilon) {
        //System.out.println(dichotomyMethod(epsilon, -9, -7));
        //System.out.println(dichotomyMethod(epsilon, -6, -4));
        //System.out.println(dichotomyMethod(epsilon, -2, -1));
        System.out.println(dichotomyMethod(epsilon, -1, 1));
        //System.out.println(dichotomyMethod(epsilon, 4, 5));
        //System.out.println(dichotomyMethod(epsilon, 7, 8));
    }
}
