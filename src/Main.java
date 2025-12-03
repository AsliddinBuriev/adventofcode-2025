import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            String command = input.nextLine().trim();
            if(command.isEmpty()){
                System.out.println("Invalid command");
                continue;
            }
            if(command.equals("q")){
                System.out.println("Bye!");
                break;
            }

        }

    }
}
