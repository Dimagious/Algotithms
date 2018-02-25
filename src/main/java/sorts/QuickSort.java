package sorts;

import java.util.Random;

/**
 * Created by Dmitriy Yurkin on 09.02.2018.
 */
public class QuickSort {
    private int[] array;

    private QuickSort(int[] array) {
        this.array = array;
    }

    private Random generator = new Random();

    private int[] createArr(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        return array;
    }

    private void quickSort(int[] array) {
        long start = System.nanoTime();
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(startIndex, endIndex);
        long end = System.nanoTime();
        System.out.println("Время работы: " + (end - start) + " мс");
    }

    private void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }

    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Сортировка 1000 элементов");
        QuickSort qs = new QuickSort(new int[1000]);
        qs.quickSort(qs.createArr(new int[1000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 10000 элементов");
        qs = new QuickSort(new int[10_000]);
        qs.quickSort(qs.createArr(new int[10_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 100000 элементов");
        qs = new QuickSort((new int[100_000]));
        qs.quickSort(qs.createArr(new int[100_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 1000000 элементов");
        qs = new QuickSort((new int[1_000_000]));
        qs.quickSort(qs.createArr(new int[1_000_000]));
    }
}