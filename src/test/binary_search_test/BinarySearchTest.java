package binary_search_test;

import auto_testcase_generation.testdatagen.templateType.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testIndexOf_ByControlFlowGraph_MCCCoverage() {
        int[] a = {};
        int k = 1;
        //test 1
        int actual = BinarySearch.indexOf(a, k);
        int expected = -1;
        Assert.assertEquals(actual, expected);
        //test 2
        a = new int[]{1, 2};
        k = 1;
        actual = BinarySearch.indexOf(a, k);
        expected = 0;
        Assert.assertEquals(actual, expected);
        //test 3
        a = new int[]{1, 2, 3};
        k = 1;
        actual = BinarySearch.indexOf(a, k);
        expected = 0;
        Assert.assertEquals(actual, expected);
        //test 4
        a = new int[]{1, 2, 3};
        k = 3;
        actual = BinarySearch.indexOf(a, k);
        expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIndexOf_ByDataFlowGraph_AllDUPathCoverage() {
        int[] a = {0, 3, 5, 8, 8, 9, 12};
        int k = 8;
        //test 1
        int actual = BinarySearch.indexOf(a, k);
        int expected = 3;
        Assert.assertEquals(expected, actual);
        //test 2
        a = new int[]{0, 3, 5, 8, 8, 9, 12};
        k = 1;
        actual = BinarySearch.indexOf(a, k);
        expected = -1;
        Assert.assertEquals(expected, actual);
        //test 3
        a = new int[]{};
        k = 1;
        actual = BinarySearch.indexOf(a, k);
        expected = -1;
        Assert.assertEquals(expected, actual);
    }
}
