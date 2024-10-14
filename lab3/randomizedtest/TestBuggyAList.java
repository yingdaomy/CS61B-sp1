package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> AList1 = new AListNoResizing<>();
        BuggyAList<Integer> AList2 = new BuggyAList<>();
        for (int i = 4; i <= 6; i += 1) {
            AList1.addLast(i);
            AList2.addLast(i);
        }
        for (int i = 0; i < 3; i += 1) {
            int excepted = AList1.removeLast();
            int actual = AList2.removeLast();
            assertEquals(excepted, actual);
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> right = new AListNoResizing<>();
        BuggyAList<Integer> wrong = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                right.addLast(randVal);
                wrong.addLast(randVal);
            } else if (operationNumber == 1) {
                int size1 = right.size();
                int size2 = wrong.size();
                assertEquals(size1, size2);
            } else if (operationNumber == 2) {
                int size1 = right.size();
                if (size1 > 0) {
                    assertEquals(right.getLast(), wrong.getLast());
                }
            } else {
                int size1 = right.size();
                if (size1 > 0) {
                    int removeitem1 = right.removeLast();
                    int removeitem2 = wrong.removeLast();
                    assertEquals(removeitem1, removeitem2);
                }
            }

        }
    }

}
