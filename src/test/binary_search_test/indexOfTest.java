package binary_search_test;

import auto_testcase_generation.testdatagen.templateType.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class IndexOfTest {

   

    @Test
    public void testIndexOf() {
        int[] a = {0, 3, 5, 8, 8, 9, 12};
        int k = 8;
        //test 1
        int actual = BinarySearch.indexOf(a, k);
        int expected = 3;
        Assert.assertEquals(expected, actual);
    @Test
    public void testIndexOfWithKeyBiggerThanMId() {
        a = new int[]{0, 3, 5, 8, 8, 9, 12};
        k = 1;
        actual = BinarySearch.indexOf(a, k);
        expected = -1;
        Assert.assertEquals(expected, actual);
    @Test
    public void testIndexOfWithEmptyArray() {
        a = new int[]{};
        k = 1;
        actual = BinarySearch.indexOf(a, k);
        expected = -1;
        Assert.assertEquals(expected, actual);
    }
}
