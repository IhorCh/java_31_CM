package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //double[] arrX = {0, 0.25, 0.5, 0.75, 1};
        double[] arrX = {0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};;
        //double[] arrY = {1, 2, 1, 0, 1};
        double[] arrY = {2, 1.95533, 1.82533, 1.62160, 1.36235, 1.07073, 0.77279, 0.49515, 0.26260, 0.09592};
        System.out.println("x: " + Arrays.toString(arrX) + "\ny: " + Arrays.toString(arrY));

        Summer x = new Summer(arrX);
        //System.out.println(x.rez);
        Summer y = new Summer(arrY);
        //System.out.println(y.rez);
        Summer xy = new Summer(arrX, arrY);
        //System.out.println(xy.rez);
        Summer xpow = new Summer(arrX, 2);
        //System.out.println(xpow.rez);

        double a1, a2;
        a1 = ((xpow.rez * y.rez) - (x.rez * xy.rez)) / ((arrX.length * xpow.rez) - Math.pow(x.rez, 2));
        a2 = ((arrX.length * xy.rez) - (y.rez * x.rez)) / ((arrX.length * xpow.rez) - Math.pow(x.rez, 2));
        System.out.println("param a1: " + a1);
        System.out.println("param a2: " + a2);
        System.out.println("polynomial: y(x)= " + a1 + a2 + "x");

        double[] lineArr = new double[arrX.length];
        double deviationSum = 0;
        for (int i = 0; i < lineArr.length; i++) {
            lineArr[i] = a1 + (a2 * arrX[i]);
            deviationSum = deviationSum + (Math.pow(lineArr[i] - arrY[i], 2));
        }
        //System.out.println(Arrays.toString(lineArr));
        // сума квадратів відхилень
        System.out.println("deviation sum: " + deviationSum);
    }
}

class Summer {
    double rez;

    Summer(double[] arr) {
        Sum(arr);
    }

    Summer(double[] arrX, double[] arrY) {
        SumMulti(arrX, arrY);
    }

    Summer(double[] arr, int pow) {
        SumPow(arr, pow);
    }

    private void Sum(double[] arr) {
        double rez = 0;
        for (int i = 0; i < arr.length; i++) {
            rez = rez + arr[i];
        }
        this.rez = rez;
    }

    private void SumMulti(double[] arrX, double[] arrY) {
        double rez = 0;
        for (int i = 0; i < arrX.length; i++) {
            rez = rez + (arrX[i] * arrY[i]);
        }
        this.rez = rez;
    }

    private void SumPow(double[] arr, int pow) {
        double rez = 0;
        for (int i = 0; i < arr.length; i++) {
            rez = rez + Math.pow(arr[i], pow);
        }
        this.rez = rez;
    }

}