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

}
