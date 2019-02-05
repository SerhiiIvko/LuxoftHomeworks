package com.luxoft.ivko.task2;

import java.util.Arrays;

public class BinarySearchInArray {
    public static void main(String[] args) {
        int[] array = new int[20];
        randomFillArray(array);

        System.out.println("Non sorted array:");
        printArray(array);
        Arrays.sort(array);

        System.out.println("Sorted array:");
        printArray(array);

        int searchInt = 15;//"magic" value for this example only! :)
        System.out.println("Value for binary search: " + searchInt);
        int indexOfSearch = binarySearchIndexOfElement(array, searchInt);
        printSearchResult(array, indexOfSearch);
    }

    private static void printSearchResult(int[] array, int index) {
        boolean isFound = false;
        for (int i1 : array) {
            if (i1 == index) {
                isFound = true;
            }
        }
        System.out.println(isFound ? "Index of searched element in array is: " + index : "Element not found!");
    }

    private static int binarySearchIndexOfElement(int[] array, int searchInt) { //binary search
        int fromIndex = 0;
        int toIndex = array.length - 1;
        while (fromIndex <= toIndex) {
            int middle = (fromIndex + toIndex) >>> 1;
            int middleValue = array[middle];
            if (middleValue < searchInt) {
                fromIndex = middle + 1;
            } else if (middleValue > searchInt) {
                toIndex = middle - 1;
            } else {
                return middle;
            }
        }
        return -(fromIndex + 1);
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
}