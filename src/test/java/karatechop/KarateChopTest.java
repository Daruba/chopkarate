package karatechop;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class KarateChopTest {
    @Test
    public void testChopEmptyArray(){
        KarateChop karateChop = new KarateChop();
        int[] numberArray = {};
        ChopModel chopModel = karateChop.chop(7, numberArray);
        Assertions.assertEquals(-1, chopModel.getArraySlot());
    }
    @Test
    public void testChopValueFoundSlot(){
        KarateChop karateChop = new KarateChop();
        int[] numberArray = {7};
        ChopModel chopModel = karateChop.chop(7, numberArray);
        Assertions.assertEquals(0, chopModel.getArraySlot());

        chopModel = karateChop.chop(6, numberArray);
        Assertions.assertEquals(-1, chopModel.getArraySlot());

        int[] numberArray2 = {5,7};
        chopModel = karateChop.chop(5, numberArray2);
        Assertions.assertEquals(0, chopModel.getArraySlot());

        chopModel = karateChop.chop(7, numberArray2);
        Assertions.assertEquals(1, chopModel.getArraySlot());

        chopModel = karateChop.chop(6, numberArray2);
        Assertions.assertEquals(-1, chopModel.getArraySlot());
    }
    @Test
    public void testBinarySearchSingleValueInArray() {
        KarateChop karateChop = new KarateChop();
        int[] numberArray = {7};
        ChopModel chopModel = karateChop.chop(7, numberArray);
        Assertions.assertEquals(0, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length);
    }

    @Test
    public void testBinarySearchManyValuesInArray() {
        KarateChop karateChop = new KarateChop();
        int[] numberArray = {1,2,3,4,5,6,7,8,9,10};
        ChopModel chopModel = karateChop.chop(7, numberArray);
        Assertions.assertEquals(6, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);

        chopModel = karateChop.chop(1, numberArray);
        Assertions.assertEquals(0, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);

        chopModel = karateChop.chop(10, numberArray);
        Assertions.assertEquals(9, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);

        chopModel = karateChop.chop(5, numberArray);
        Assertions.assertEquals(4, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);
    }
    @Test
    public void testBinarySearchUnorderedArray() {
        KarateChop karateChop = new KarateChop();
        int[] numberArray = {1,3,5,7,9,2,4,6,8,10};
        ChopModel chopModel = karateChop.chop(7, numberArray);
        Assertions.assertEquals(6, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);

        chopModel = karateChop.chop(1, numberArray);
        Assertions.assertEquals(0, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);

        chopModel = karateChop.chop(10, numberArray);
        Assertions.assertEquals(9, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);

        chopModel = karateChop.chop(5, numberArray);
        Assertions.assertEquals(4, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);
    }
    @Test
    public void intBoundary(){

        KarateChop karateChop = new KarateChop();
        int[] numberArray = {1,3,5,7,9,2,4,6,8,10};
        ChopModel chopModel = karateChop.chop(2147483647, numberArray);
        Assertions.assertEquals(-1, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);

        int[] numberArray2 = {1,3,5,7,9,2,4,6,8,10,11,12,13,14,2147483647};
        chopModel = karateChop.chop(2147483647, numberArray2);
        Assertions.assertEquals(14, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);

        int[] numberArray3 =  {1,3,5,7,9,2,4,-6,8,10,11,12,13,14,-2147483647};
        chopModel = karateChop.chop(-2147483647, numberArray3);
        Assertions.assertEquals(0, chopModel.getArraySlot());
        Assertions.assertTrue(chopModel.getSearchCount() > 0);
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);
    }
}
