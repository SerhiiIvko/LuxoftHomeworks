package com.luxoft.ivko.task3;

import static java.lang.System.arraycopy;

class MyMergeSort {
    private int[] inputArray;
    private int[] temporaryMergeArray;

    void sort(int[] inputArr) {
        this.inputArray = inputArr;
        int length = inputArr.length;
        this.temporaryMergeArray = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        if (higherIndex + 1 - lowerIndex >= 0)
            arraycopy(inputArray, lowerIndex, temporaryMergeArray, lowerIndex, higherIndex + 1 - lowerIndex);
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (temporaryMergeArray[i] <= temporaryMergeArray[j]) {
                inputArray[k] = temporaryMergeArray[i];
                i++;
            } else {
                inputArray[k] = temporaryMergeArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            inputArray[k] = temporaryMergeArray[i];
            k++;
            i++;
        }
    }
}