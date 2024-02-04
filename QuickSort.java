package com.mycompany.quicksort;


public class QuickSort {

    public static void main(String[] args) {
        int[] dizi = new int[5];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = (int) (Math.random() * 10);
        }

        System.out.print("Normal Dizi : ");
        for (int i = 0; i < dizi.length; i++) System.out.print(dizi[i] + ",");
        System.out.println();

        quickSort(dizi, 0, dizi.length - 1);

        System.out.print("Sıralı Dizi : ");
        for (int i = 0; i < dizi.length; i++) System.out.print(dizi[i] + ",");
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            
            int pivotIndex = partition(arr, low, high);

            
            quickSort(arr, low, pivotIndex - 1);
            
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}