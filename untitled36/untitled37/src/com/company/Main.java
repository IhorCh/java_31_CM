package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        double epsilon = 0.001;
        System.out.println(dichotomyMethod(epsilon, 0, 1));
    }

    public static double function(double x) {
        double f = Math.tan(x) - Math.pow(x, 2) - 0.5;
        //double f = 1 / (1 + Math.pow(x, 2)) - x;
        return f;
    }

    public static double dichotomyMethod(double epsilon, double a, double b) {
        double x = 0;
        double c = 0;
        double prevA = a;
        double prevB = b;
        int iteration = 0;
        while ((b - a) > epsilon) {
            c = (a + b) / 2;
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
        System.out.println("Dichotomy method with epsilon = " + epsilon + '\n' + x + '\n');
        //System.out.println("Mismatch: " + mismatch(x) + '\n');

        System.out.println("Sowing with epsilon = " + eps);
        return sowing(x, c, eps);
    }

    public static double sowing(double xcur, double xprev, double eps) {
        double x = 0;
        int iteration = 0;
        do {
            //x = xprev - (function(xprev) / ((function(xprev + eps) - function(xprev)) / eps));
            x = xcur - ((function(xcur) * (xcur - xprev)) / (function(xcur) - function(xprev)));
            //x = xcur - (function(xcur)/functionPOX(xcur));
            xprev = xcur;
            xcur = x;
            System.out.println("changing x: " + x);
            iteration++;
        }
        while (Math.abs(xcur - xprev) > eps);
        System.out.println("iterations: " + iteration);
        System.out.println("mismatch: " + mismatch(x));
        System.out.println("result: ");
        return x;
    }

    public static double mismatch(double x) {
        return Math.abs(function(x));
    }
}

