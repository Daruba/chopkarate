package karatechop;

public class KarateChop {
    public int chop(int searchNumber, int[] numberArray) {
        for(int i = 0; i<numberArray.length; i++){
            if(searchNumber == numberArray[i]){
                return i;
            }
        }
        return -1;
    }
}
