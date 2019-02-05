package com.luxoft.ivko.task1;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[15];
        randomFillArray(array);

        System.out.println("Non sorted array:");
        printArray(array);

        System.out.println();

        System.out.println("First algorithm sorting array result:");
        firstBubbleSortMethod(array);//first algorithm bubble sort
        printArray(array);

        System.out.println();

        System.out.println("Second algorithm sorting array result:");
        secondBubbleSortMethod(array);//other algorithm bubble sort
        printArray(array);
    }

    private static void randomFillArray(int[] array) { //fill array random int values
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20);
        }
    }

    private static void printArray(int[] array) { //print array
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println();
    }

    private static void secondBubbleSortMethod(int[] array) {
        int tmp;
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] <= array[j - 1]) {
                    tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    private static void firstBubbleSortMethod(int[] array) {
        int tmp;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
}