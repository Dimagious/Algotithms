package sorts;

import java.util.Random;

public class MergeSort {
    private int[] array;

    private MergeSort(int[] array) {
        this.array = array;
    }

    private Random generator = new Random();

    private int[] createArr(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        return array;
    }

    private static void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    private static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        System.arraycopy(array, 0, left, 0, size1);
        return left;
    }

    private static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        System.arraycopy(array, size1, right, 0, size2);
        return right;
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Сортировка 1000 элементов");
        MergeSort ms = new MergeSort(new int[1000]);
        long start = System.nanoTime();
        mergeSort(ms.createArr(new int[1000]));
        long end = System.nanoTime();
        System.out.println("Время работы: " + (end - start) + " мс");

        System.out.println("-------------------------");
        System.out.println("Сортировка 10000 элементов");
        ms = new MergeSort(new int[10_000]);
        start = System.nanoTime();
        mergeSort(ms.createArr(new int[10_000]));
        end = System.nanoTime();
        System.out.println("Время работы: " + (end - start) + " мс");

        System.out.println("-------------------------");
        System.out.println("Сортировка 100000 элементов");
        ms = new MergeSort(new int[100_000]);
        start = System.nanoTime();
        mergeSort(ms.createArr(new int[100_000]));
        end = System.nanoTime();
        System.out.println("Время работы: " + (end - start) + " мс");

        System.out.println("-------------------------");
        System.out.println("Сортировка 1000000 элементов");
        ms = new MergeSort(new int[1_000_000]);
        start = System.nanoTime();
        mergeSort(ms.createArr(new int[1_000_000]));
        end = System.nanoTime();
        System.out.println("Время работы: " + (end - start) + " мс");
    }
}