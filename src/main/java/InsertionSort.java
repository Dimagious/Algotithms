import java.util.Random;

/**
 * Created by Dmitriy Yurkin on 13.02.2018.
 */
class InsertionSort {
    private int[] array;

    private InsertionSort(int[] array) {
        this.array = array;
    }

    private Random generator = new Random();

    private int[] createArr(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        return array;
    }

    private void sort(int arr[]) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        for (int i=1; i<n; ++i) {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        long end = System.currentTimeMillis();
        System.out.println("Время работы: " + (end - start) + " мс");
    }

    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Сортировка 1000 элементов");
        InsertionSort is = new InsertionSort(new int[1000]);
        is.sort(is.createArr(new int[1000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 10000 элементов");
        is = new InsertionSort(new int[10_000]);
        is.sort(is.createArr(new int[10_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 100000 элементов");
        is = new InsertionSort(new int[100_000]);
        is.sort(is.createArr(new int[100_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 1000000 элементов");
        is = new InsertionSort(new int[1_000_000]);
        is.sort(is.createArr(new int[1_000_000]));
    }
}