package karatechop;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class KarateChopTest {
    @Test
    public void testChopEmptyArray(){
        KarateChop karateChop = new KarateChop();
        int[] numberArray = {};
        Assertions.assertEquals(-1, karateChop.chop(7, numberArray));
    }
    @Test
    public void testChopValueFoundSlot(){
        KarateChop karateChop = new KarateChop();
        int[] numberArray = {7};
        Assertions.assertEquals(0, karateChop.chop(7, numberArray));
        Assertions.assertEquals(-1, karateChop.chop(6, numberArray));

        int[] numberArray2 = {5,7};
        Assertions.assertEquals(0, karateChop.chop(5, numberArray2));
        Assertions.assertEquals(1, karateChop.chop(7, numberArray2));
        Assertions.assertEquals(-1, karateChop.chop(6, numberArray2));
    }

}
