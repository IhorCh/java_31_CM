package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        double[] arrX = {0.0, 0.8, 1.6, 2.4, 3.2, 4.0};
        double[] arrY = {function(0.0), function(0.8), function(1.6),function(2.4), function(3.2), function(4.0)};
        //double[] arrX = {0, 1, 2, 3, 5};
        //double[] arrY = {1, 0, 2, 1, 4};
        double[] rez = RosdRizn(arrX, arrY);

        System.out.println("x = 0.066, polinom = " + Gorner(1, arrX, arrY, rez));
        System.out.println("x = 0.368, polinom = " + Gorner(2, arrX, arrY, rez));
        System.out.println("x = 0.623, polinom = " + Gorner(3, arrX, arrY, rez));
        String r = Arrays.toString(rez);
        //System.out.println(r);
    }

    public static double[] RosdRizn(double[] arrX, double[] arrY) {
        double[] rez = new double[arrX.length - 1];
        int jCounter = 2;
        int iter = 2;
        for (int k = 0; k < rez.length; k++) {

            for (int j = 0; j < jCounter; j++) {
                double tmp = arrY[j];
                double tmp2 = 1;
                for (int i = 0; i < iter; i++) {
                    if (j != i) {
                        tmp2 = tmp2 * (arrX[j] - arrX[i]);
                    }
                }
                tmp = tmp / tmp2;
                rez[k] = rez[k] + tmp;
            }
            if (iter < arrX.length) {
                iter++;
            }
            if (jCounter < arrX.length) {
                jCounter++;
            }
        }
        String r = Arrays.toString(rez);
        System.out.println(r);
        return rez;
    }

    public static double Gorner (double x, double[] arrX, double[] arrY, double[] rez) {
        double tmp = 0;
        for (int i = rez.length-1; i >= 0; i--) {
            double a = x - arrX[i];
            double b = rez[i];
            b = tmp + b;
            tmp = a*b;
        }
        tmp = tmp + arrY[0];

        return tmp;
    }
    public static double function(double x) {
        double res = (1/(x+10)) + (1/2 * Math.pow(x,7));
        return res;
    }
}
