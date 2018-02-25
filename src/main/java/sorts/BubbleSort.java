package sorts;

/**
 * Created by Dmitriy Yurkin on 09.02.2018.
 */
public class BubbleSort {
    private void bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        long end = System.currentTimeMillis();;
        System.out.println("Время работы: " + (end - start) + " мс");
    }

    private int[] createArr(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Сортировка 1000 элементов");
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(bs.createArr(new int[1000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 10000 элементов");
        bs = new BubbleSort();
        bs.bubbleSort(bs.createArr(new int[10_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 100000 элементов");
        bs = new BubbleSort();
        bs.bubbleSort(bs.createArr(new int[100_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 1000000 элементов");
        bs = new BubbleSort();
        bs.bubbleSort(bs.createArr(new int[1_000_000]));
    }
}