package deque;

import org.junit.Test;
import static org.junit.Assert.*;

/** performs the basic function of ArrayDeque */
public class ArrayDequeTest {

    /**
     * Add items into an ArrayDeque and check if they are added correctly.
     */
    @Test
    public void AddFirstLastTest() {

        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.addFirst("middle");
        ad.addFirst("front");
        ad.addLast("back");

        assertEquals("front", ad.removeFirst());
        assertEquals("middle", ad.removeFirst());
        assertEquals("back", ad.removeFirst());

    }

    /**
     * Add one item into an empty ArrayDeque and check if the isEmpty method and size method are correct.
     */
    @Test
    public void isEmptySizeTest() {
        ArrayDeque<String> ad = new ArrayDeque<>();
        assertEquals(true, ad.isEmpty());
        ad.addLast("middle");
        ad.addLast("back");
        ad.addFirst("front");
        assertEquals(3, ad.size());
        assertEquals(false, ad.isEmpty());
        assertEquals("front", ad.removeFirst());
        assertEquals("back", ad.removeLast());
        assertEquals("middle", ad.removeFirst());
        assertEquals(true, ad.isEmpty());
    }

    /**
     * Test if the removeFirst and removeLast method are correct.
     */
    @Test
    public void removeFirstLastTest() {
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.addFirst("front");
        ad.addLast("middle");
        ad.addLast("back");
        assertEquals("front", ad.removeFirst());
        assertEquals("middle", ad.removeFirst());
        assertEquals("back", ad.removeLast());
    }

    /**
     * Test the get method
     */
    @Test
    public void getTest() {
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.addFirst("front");
        ad.addLast("middle");
        ad.addLast("back");
        assertEquals("middle", ad.get(1));
        assertEquals("front", ad.get(0));
        assertEquals("back", ad.get(2));
    }

    /**
     * Test the printDeque method
     */
    @Test
    public void printDequeTest() {
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.addFirst("front");
        ad.addLast("middle");
        ad.addLast("back");
        ad.printDeque();
    }

    /** Add large number of elements to deque; check if order is correct. */
    @Test
    public void bigArrayDequeTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i += 1) {
            ad.addLast(i);
        }
        for (int i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) ad.removeFirst(), 0.0);
        }

        for (int i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) ad.removeLast(), 0.0);
        }
    }
}


