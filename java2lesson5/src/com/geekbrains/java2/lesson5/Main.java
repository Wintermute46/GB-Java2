package com.geekbrains.java2.lesson5;

public class Main {

    public static void main(String[] args) {

        final int size = 10000000;
        float[] arr1 = new float[size];

        for (int i = 0; i < size; i++) {
            arr1[i] = 1.0f;
        }

        float[] arr2 = arr1.clone();

        System.out.println("Время выполнения операции в одном потоке: " + singleThread(arr1) + " мс");
        System.out.println("Время выполнения операции в двух потоках: " + dualThread(arr2) + " мс");

    }

    public static long singleThread (float[] array) {
        long start = System.currentTimeMillis();

        Thread th1 = new Thread(new ArrManipulations(array));
        th1.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - start;
    }

    public static long dualThread (float[] array) {
        int h = array.length / 2;
        float[] a1 = new float[h], a2 = new float[h];
        long start = System.currentTimeMillis();

        System.arraycopy(array, 0 , a1, 0, h);
        System.arraycopy(array, h , a2, 0, h);

        Thread th1 = new Thread(new ArrManipulations(a1));
        Thread th2 = new Thread(new ArrManipulations(a2));

        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e ) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0 , array, 0, h);
        System.arraycopy(a2, 0 , array, h, h);

        return System.currentTimeMillis() - start;
    }
}
