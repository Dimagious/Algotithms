package sorts;

import java.util.Random;

/**
 * Created by Dmitriy Yurkin on 13.02.2018.
 */

public class SelectionSort {
    private int[] array;

    private SelectionSort(int[] array) {
        this.array = array;
    }

    private Random generator = new Random();

    private int[] createArr(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        return array;
    }

    void selectionSort(int[] array) {
        long start = System.currentTimeMillis();
        for (int k = 0; k < array.length-1; k++){
            int min_idx = k;
            for (int j = k + 1; j<array.length; j++){
                if (array[j] < array[min_idx])
                    min_idx = j;
            }

            //swap
            int temp = array[min_idx];
            array[min_idx] = array[k];
            array[k] = temp;
        }
        long end = System.currentTimeMillis();
        System.out.println("Время работы: " + (end - start) + " мс");
    }

    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Сортировка 1000 элементов");
        SelectionSort ss = new SelectionSort(new int[1000]);
        ss.selectionSort(ss.createArr(new int[1000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 10000 элементов");
        ss = new SelectionSort(new int[10_000]);
        ss.selectionSort(ss.createArr(new int[10_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 100000 элементов");
        ss = new SelectionSort(new int[100_000]);
        ss.selectionSort(ss.createArr(new int[100_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 1000000 элементов");
        ss = new SelectionSort(new int[1_000_000]);
        ss.selectionSort(ss.createArr(new int[1_000_000]));
    }
}