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
        System.out.println(chopModel.getSearchCount());
        Assertions.assertTrue(chopModel.getSearchCount() <= numberArray.length/2);
    }

}
