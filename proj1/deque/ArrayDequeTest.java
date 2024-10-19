package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addIsEmptyTestSize() {

        ArrayDeque<String> ad1 = new ArrayDeque<>();
        assertTrue("A newly initialized ALDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");
        assertFalse("Now the ALDeque should contain 1 item", ad1.isEmpty());
        assertEquals(1, ad1.size());
        ad1.addLast("middle");
        assertEquals(2, ad1.size());
        ad1.addLast("back");
        assertEquals(3, ad1.size());
        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    public void addRemoveTest() {

        ArrayDeque<String> ad2 = new ArrayDeque<>();
        assertTrue("A newLy initialized ALDeque should be empty", ad2.isEmpty());
        ad2.addFirst("back");
        ad2.addFirst("middle");
        ad2.addFirst("front");
        assertEquals("front",ad2.removeFirst());
        assertEquals("back", ad2.removeLast());
        System.out.println("Printing out deque: ");
        ad2.printDeque();
    }

    @Test
    public void removeEmptyTest() {


        ArrayDeque<Integer> ad3 = new ArrayDeque<>();
        ad3.addFirst(3);

        ad3.removeLast();
        ad3.removeFirst();
        ad3.removeLast();
        ad3.removeFirst();

        int size = ad3.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    public void multipleParamTest() {


        ArrayDeque<String>  ad1 = new ArrayDeque<String>();
        ArrayDeque<Double>  ad2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<Boolean>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();

    }

    @Test
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, ad1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, ad1.removeLast());

    }

    @Test
    public void bigALDequeTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 5; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 9; i > 5; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }

    }

}
