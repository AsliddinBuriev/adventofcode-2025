import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SecretEntrance {
    private final int INITIAL_POINT = 50;
    private final int UPPER_LIMIT = 100;
    private final String INPUT_FILE = "secret-entrance-input.txt";

    public int findDoorPasswordPart1(){
        int zeroCount = 0;
        int currentPoint = INITIAL_POINT;
        String[] input = readInstructionsFromFile();

        for( String s : input ){
            int instruction = Integer.parseInt(s.substring(1));
            if(s.startsWith("L")){
                currentPoint = (currentPoint - instruction + UPPER_LIMIT) % UPPER_LIMIT;
            }else{
                currentPoint = (currentPoint + instruction) % UPPER_LIMIT;
            }
            if(currentPoint == 0){
                zeroCount++;
            }
        }

        return zeroCount;
    }

    public int findDoorPasswordPart2(){
        int zeroCount = 0;
        int currentPoint = INITIAL_POINT;
        String[] input = readInstructionsFromFile();

        for(String s : input){
            int instruction = Integer.parseInt(s.substring(1));
            zeroCount += instruction / UPPER_LIMIT;

            int remainder = instruction % UPPER_LIMIT;

            if (s.startsWith("L")) {
                if (currentPoint > 0 && remainder >= currentPoint) {
                    zeroCount++;
                }
                currentPoint = (currentPoint - instruction) % UPPER_LIMIT;
                if (currentPoint < 0) {
                    currentPoint += UPPER_LIMIT;
                }

            } else {
                if (UPPER_LIMIT - currentPoint <= remainder) {
                    zeroCount++;
                }
                currentPoint = (currentPoint + instruction) % UPPER_LIMIT;
            }
        }
        return zeroCount;
    }

    public String[] readInstructionsFromFile(){
        List<String> instructionsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    instructionsList.add(line);
                }
            }
        }catch (Exception e){
            System.err.println("Error reading instructions from file: " + INPUT_FILE);
        }

        return instructionsList.toArray(new String[0]);
    }
}
