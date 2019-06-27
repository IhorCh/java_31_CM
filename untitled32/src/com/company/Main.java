package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // метод Зейделя
        //double[][] matrixA = {{13.2, 1.9, 2.3}, {0.8, -7.3, -0.7}, {0.5, -1.4, -9.6}};
        //double[] vectorF = {5.12, 5.2, 1.5};
        //double epsilon = 0.00000001;
        /*double[][] matrixA = {
                {0.51, -0.074, 0.01, -0.13, 0.09},
                {0.08, 0.3, -0.036, 0, 0.05},
                {0.15, 0, 0.42, 0.06, -0.07},
                {0.19, 0.023, 0.06, 0.438, 0},
                {0.05, -0.07, 0.023, 0, 0.36}};
        //double[] vectorF = {0.708, 2.578, -0.19, 1.64, -2.229};*/
        double[][] matrixA = {
                {2, 2, 0, 0, 0, 0, 0},
                {-3, 8, -4, 0, 0, 0, 0},
                {0, 5, 8, 2, 0, 0, 0},
                {0, 0, -4, 8, -4, 0, 0},
                {0, 0, 0, -2, 8, 2, 0},
                {0, 0, 0, 0, -3, 10, 2},
                {0, 0, 0, 0, 0, 3, 3}};
        double[] vectorF = {-12, -45, -7, 0, 4, 26, 3};
        double epsilon = 0.00000001;
        String str = Arrays.toString(func(matrixA, vectorF, epsilon));
        System.out.println(str);
    }

    public static double[] func(double[][] matrixA, double[] vectorF, double epsilon) {
        double[] vectorX = new double[matrixA.length];// x1 0 0 0 0
        double[] beforeX = new double[vectorX.length];// 0 0 0 0 0
        double[] vectorRESULT = new double[vectorX.length];
        double[] delta = new double[vectorX.length];
        double maxDelta = 0;
        int iteration = 0;
        do {
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < vectorX.length; j++) {
                    if (j != i) {
                        vectorRESULT[i] += -(matrixA[i][j] * vectorX[j]);
                    }
                }
                vectorRESULT[i] = vectorF[i] + vectorRESULT[i];
                vectorRESULT[i] = vectorRESULT[i] / (matrixA[i][i]);
                vectorX[i] = vectorRESULT[i];
                delta[i] = Math.abs(beforeX[i] - vectorX[i]);
                maxDelta = delta[0];
                for (int k = 1; k < delta.length; k++) {
                    if (maxDelta < delta[k]) {
                        maxDelta = delta[k];
                    }
                }
            }
            for (int k = 0; k < vectorX.length; k++) {
                vectorRESULT[k] = 0;
                beforeX[k] = vectorX[k];
            }
            iteration++;
        }
        while (maxDelta > epsilon);
        System.out.println("iterations: " + iteration);
        String str = Arrays.toString(mismatch(matrixA, vectorX, vectorF));
        System.out.println("mismatch: ");
        System.out.println(str);
        System.out.println(Arrays.toString(vectorF));
        System.out.println("result: ");
        return vectorX;
    }

    private static double[] mismatch(double[][] matrixA, double[] vectorX, double[] vectorF) {
        double[] mis = new double[matrixA.length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                mis[i] = mis[i] + (matrixA[i][j] * vectorX[j]);
            }
            //mis[i] = mis[i] - vectorF[i];
        }
        return mis;
    }
}