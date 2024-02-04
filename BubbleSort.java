package com.mycompany.bubblesort;


public class BubbleSort {

    public static void main(String[] args) {
        int[] dizi = new int[10];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = (int) (Math.random()*10);
        }
        int temp;
        System.out.print("Normal Dizi : ");
        for (int i = 0; i < dizi.length; i++) System.out.print(dizi[i]+ ",");
        System.out.println();
        
         
            
        
        for (int i = 0; i < dizi.length-1; i++) {
            for (int j = 0; j < dizi.length-1-i; j++) {
                if (dizi[j] > dizi[j+1]) {
                    temp = dizi[j];
                    dizi[j] = dizi[j+1];
                    dizi[j+1] = temp;
                }
            }
        }
        System.out.print("Sıralanmış Dizi : ");
        for (int i = 0; i < dizi.length; i++) System.out.print(dizi[i] + ",");
    }
}
