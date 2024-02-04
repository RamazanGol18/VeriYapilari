package com.mycompany.selectionsort;


public class SelectionSort {

    public static void main(String[] args) {
        int[] dizi = new int[10];

        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = (int) (Math.random() * 10);
        }

        System.out.print("Normal Dizi: ");
        for (int i = 0; i < dizi.length; i++)
            System.out.print(dizi[i] + ",");
        System.out.println();

        for (int i = 0; i < dizi.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < dizi.length; j++) {
                
                if (dizi[j] < dizi[minIndex]) {
                    minIndex = j;
                }
            }

            
            int temp = dizi[i];
            dizi[i] = dizi[minIndex];
            dizi[minIndex] = temp;
        }

        System.out.print("Sıralanmış Dizi: ");
        for (int i = 0; i < dizi.length; i++)
            System.out.print(dizi[i] + ",");
    }
}