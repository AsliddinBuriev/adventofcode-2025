import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter command: ");
            String cmd = input.nextLine();
            if (cmd.equals("q") || cmd.equals("quit")) {
                break;
            }
        }
    }
}
