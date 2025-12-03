import java.util.ArrayList;
import java.util.List;

public class GiftShop {

    public Long invalidIdSum(String input){
        String[][] rangeArray = parseArgs(input);

        List <Long> invalidIds = new ArrayList<>();

        for (String[] range : rangeArray) {
            findInvalidIds(invalidIds, range[0], range[1]);
        }
        Long sum = 0L;
        for(Long id : invalidIds){
            sum += id;
        }
        return sum;
    }

    private void findInvalidIds(List<Long> ids, String lower, String upper){
        long lowerNum = Long.parseLong(lower);
        long upperNum = Long.parseLong(upper);

        for (int len = lower.length(); len <= upper.length(); len++) {
            if (len % 2 != 0) continue;

            int halfLen = len / 2;
            long minFirstHalf = (long) Math.pow(10, halfLen - 1);
            long maxFirstHalf = (long) Math.pow(10, halfLen) - 1;

            if (len == lower.length()) {
                minFirstHalf = Math.max(minFirstHalf, lowerNum / (long) Math.pow(10, halfLen));
            }
            if (len == upper.length()) {
                maxFirstHalf = Math.min(maxFirstHalf, upperNum / (long) Math.pow(10, halfLen));
            }

            for (long firstHalf = minFirstHalf; firstHalf <= maxFirstHalf; firstHalf++) {
                long symmetricNum = firstHalf * (long) Math.pow(10, halfLen) + firstHalf;
                if (symmetricNum >= lowerNum && symmetricNum <= upperNum) {
                    ids.add(symmetricNum);
                }
            }
        }
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
