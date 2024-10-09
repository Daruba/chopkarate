package karatechop;

public class KarateChop {
    public ChopModel chop(int searchNumber, int[] numberArray) {
        ChopModel chopModel = new ChopModel();
        for(int i = 0; i<numberArray.length; i++){
            if(searchNumber == numberArray[i]){
                chopModel.setArraySlot(i);
                return chopModel;
            }
        }
        return chopModel;
    }
}
