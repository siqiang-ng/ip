import java.net.IDN;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private final static String INDENT = "    ";
    private final static String horizL = INDENT +
            "____________________________________________________________";
    private final static String logo = INDENT + " ____        _        \n"
            + INDENT + "|  _ \\ _   _| | _____ \n"
            + INDENT + "| | | | | | | |/ / _ \\\n"
            + INDENT + "| |_| | |_| |   <  __/\n"
            + INDENT + "|____/ \\__,_|_|\\_\\___|\n";
    private static ArrayList<String> lst = new ArrayList<>();

    private static void intro() {
        System.out.println(horizL + "\n" + logo + "\n" +
                INDENT + "Hello. I'm Duke.\n" +
                INDENT + "How can I help you?\n" + horizL);
    }

    private static void ending() {
        System.out.println("\n" + INDENT +
                "Bye! Hope to see you again soon!\n" + horizL);
    }

    private static void displayList() {
        int len = lst.size();
        int index = 1;
        System.out.println(horizL);
        for (int i = 0; i < len; i++) {
            System.out.println(INDENT + index + ". " + lst.get(i));
            index++;
        }
        System.out.println(horizL);
    }

    public static void main(String[] args) {
        Duke.intro();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.toLowerCase().equals("bye")) {
                System.out.print(horizL);
                break;
            } else if (input.toLowerCase().equals("list")) {
                Duke.displayList();
            } else {
                lst.add(input);
                System.out.println(horizL);
                System.out.println(INDENT + "Added: " + input);
                System.out.println(horizL);
            }
        }
        Duke.ending();
    }
}
