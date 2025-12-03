import java.util.ArrayList;
import java.util.List;

public class GiftShop {

    public int invalidIdSum(String input){
        String[][] rangeArray = parseArgs(input);

        List <Integer> invalidIds = new ArrayList<>();

        for (String[] range : rangeArray) {
            findInvalidIds(invalidIds, range[0], range[1]);
        }

        int sum = 0;

        for(Integer id : invalidIds){
            sum += id;
        }
        return sum;
    }

    private void findInvalidIds(List<Integer> ids, String lower, String upper){
        if(lower.length() == upper.length() && lower.length() %2 > 0) return ;
        // bruteforce

    }


    private String[][] parseArgs(String input) {
        String[] rangeList = input.split(",");
        String[][] rangeArray = new String[rangeList.length][];
        for (int i = 0; i < rangeList.length; i++) {
            rangeArray[i] = rangeList[i].split("-");
        }
        return rangeArray;
    }
}
