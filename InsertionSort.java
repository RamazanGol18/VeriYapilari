package com.mycompany.insertionsort;


public class InsertionSort {

    public static void main(String[] args) {
        int[] dizi = new int[10];

        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = (int) (Math.random() * 10);
        }

        System.out.print("Normal Dizi: ");
        for (int i = 0; i < dizi.length; i++)
            System.out.print(dizi[i] + ",");
        System.out.println();

       
        for (int i = 1; i < dizi.length; i++) {
            int currentEleman = dizi[i];
            int j = i - 1;

            
            while (j >= 0 && dizi[j] > currentEleman) {
                dizi[j + 1] = dizi[j];
                j--;
            }

            
            dizi[j + 1] = currentEleman;
        }

        System.out.print("Sıralanmış Dizi: ");
        for (int i = 0; i < dizi.length; i++)
            System.out.print(dizi[i] + ",");
    }
}