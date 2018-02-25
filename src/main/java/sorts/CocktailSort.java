package sorts;

import java.util.Random;

/**
 * Created by Dmitriy Yurkin on 13.02.2018.
 */
public class CocktailSort{
    private int[] array;

    private CocktailSort(int[] array) {
        this.array = array;
    }

    private Random generator = new Random();

    private int[] createArr(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        return array;
    }

    private void sort(int[] array) {
        long start = System.currentTimeMillis();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= array.length - 2; i++) {
                if (array[i] > array[i+1]) {
                    //Проверяем находятся ли два элемента в неправильном порядке
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                //Если перестановок не произошло, выходим из цмкла
                break;
            }
            swapped = false;
            for (int i = array.length - 2; i >= 0; i--) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    swapped = true;
                }
            }
            //Если элементы не переставлялись, список отсортирован
        } while (swapped);
        long end = System.currentTimeMillis();
        System.out.println("Время работы: " + (end - start) + " мс");
    }

    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Сортировка 1000 элементов");
        CocktailSort cs = new CocktailSort(new int[1000]);
        cs.sort(cs.createArr(new int[1000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 10000 элементов");
        cs = new CocktailSort(new int[10_000]);
        cs.sort(cs.createArr(new int[10_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 100000 элементов");
        cs = new CocktailSort(new int[100_000]);
        cs.sort(cs.createArr(new int[100_000]));

        System.out.println("-------------------------");
        System.out.println("Сортировка 1000000 элементов");
        cs = new CocktailSort(new int[1_000_000]);
        cs.sort(cs.createArr(new int[1_000_000]));
    }
}