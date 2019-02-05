package com.luxoft.ivko.task3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortApp {
    public static void main(String[] a) {
        int[] inputArr = new int[25];
        randomFillArray(inputArr);
        System.out.println("Non sorted array: ");
        printArray(inputArr);

        MyMergeSort mergeSort = new MyMergeSort();
        mergeSort.sort(inputArr);

        System.out.println("Sorted array:");
        printArray(inputArr);
    }

    private static void randomFillArray(int[] array) { //fill array random int values
        IntStream.range(0, array.length).forEach(i -> array[i] = (int) (Math.random() * 20));
    }

    private static void printArray(int[] array) { //print array
        Arrays.stream(array).mapToObj(anArray -> anArray + " ").forEach(System.out::print);
        System.out.println();
    }
}