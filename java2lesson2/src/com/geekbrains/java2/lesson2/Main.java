package com.geekbrains.java2.lesson2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[][] myArr = {{"5", "3", "1", "8"},
                {"2", "0", "25", "99"},
                {"4", "3", "6", "7"},
                {"11", "14", "8", "5"}};

        System.out.println("Исходный массив:");
        for (int i = 0; i < myArr.length; i++)
            System.out.println(Arrays.toString(myArr[i]));

        try {
            System.out.println("Сумма элементов массива: " + myMatrixMethod(myArr));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }


    }

    public static int myMatrixMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int arraySize = 4;
        int arrSum = 0;
        int i = 0, j = 0;
        boolean isNotArrSize = false;

        if (array.length == arraySize) {
            for (i = 0; i < arraySize; i++) {
                if (array[i].length != arraySize) {
                    isNotArrSize = true;
                    break;
                }
            }
        } else isNotArrSize = true;

        if (isNotArrSize)
            throw new MyArraySizeException("Размер массива не соответствует требуемому! (" + arraySize + " x " + arraySize + ")");

        try {
            for (i = 0; i < arraySize; i++) {
                for (j = 0; j < arraySize; j++) {
                    arrSum += Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException((j + 1) + "-й элемент " + (i + 1) + "-й строки не является числом!");
        }

        return arrSum;
    }

}
