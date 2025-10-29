// HelpDeskStation.java
import java.util.Scanner;

public class HelpDeskStation {
    private final String name;
    private final QueueSystem queue;

    public HelpDeskStation(String name) {
        this.name = name;
        this.queue = QueueSystem.getInstance();
    }

    public void serve() {
        System.out.println("[" + name + "] Serving: " + queue.getCurrent());
    }

    public void reset(Scanner scanner) {
        System.out.print("[" + name + "] Reset to: ");
        int num;
        try {
            num = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("\nInvalid input.");
            return;
        }
        queue.reset(num);
    }
}