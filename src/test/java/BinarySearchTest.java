import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Dmitriy Yurkin on 08.02.2018.
 */
class BinarySearchTest {
    @Test
    void find() {
        BinarySearch bs = new BinarySearch(null);
        assertTrue(bs.find(7) == -1);;

        bs = new BinarySearch(new double[0]);
        assertTrue(bs.find(7) == -1);

        bs = new BinarySearch(new double[]{7});
        assertTrue( bs.find(7) == 0);
        assertTrue(bs.find(20) == -1);

        bs = new BinarySearch(new double[]{7, 20});
        assertTrue(bs.find(-30) == -1);
        assertTrue(bs.find(7) == 0);
        assertTrue(bs.find(12) == -1);
        assertTrue(bs.find(20) == 1);
        assertTrue(bs.find(30) == -1);

        bs = new BinarySearch(new double[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50});
        assertTrue(bs.find(-30) == -1);
        assertTrue(bs.find(-16) == 0);
        assertTrue(bs.find(7) == 5);
        assertTrue(bs.find(20) == 8);
        assertTrue(bs.find(24) == 9);
        assertTrue(bs.find(50) == 14);
        assertTrue(bs.find(40) == -1);
        assertTrue(bs.find(60) == -1);
    }
}