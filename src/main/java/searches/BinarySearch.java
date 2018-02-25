package searches;

/**
 * Created by Dmitriy Yurkin on 08.02.2018.
 */
public class BinarySearch {
    private double[] array;

    BinarySearch(double[] array) {
        this.array = array;
    }

    public int find(double x) {
        int i = -1;
        if (this.array != null) {
            int low = 0, high = this.array.length, mid;
            while (low < high) {
                mid = (low + high) / 2;
                if (x == this.array[mid]) {
                    i = mid;
                    break;
                } else {
                    if (x < this.array[mid]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return i;
    }
}