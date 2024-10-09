package karatechop;

import java.util.Arrays;

public class KarateChop {

    public ChopModel chop(int searchNumber, int[] numberArray) {
        ChopModel chopModel = new ChopModel();
        numberArray = Arrays.stream(numberArray).sorted().toArray();
        if (numberArray.length == 0) {
            return chopModel;
        }
        int startPoint = 0;
        int endPoint = numberArray.length - 1;

        while (startPoint <= endPoint) {
            int middle = startPoint + (endPoint - startPoint) / 2;
            chopModel.setSearchCount(chopModel.getSearchCount() + 1);
            if (numberArray[middle] == searchNumber) {
                chopModel.setArraySlot(middle);
                break;
            }
            if (numberArray[middle] < searchNumber) {
                startPoint = middle+1;

            } else {
                endPoint = middle - 1;
            }
        }
        return chopModel;
    }
}
