// QueueSystem.java
public class QueueSystem {
    private static QueueSystem instance;
    private int currentQueueNumber = 0;

    private QueueSystem() {}

    public static QueueSystem getInstance() {
        if (instance == null) {
            instance = new QueueSystem();
        }
        return instance;
    }

    public int issueNextNumber() {
        currentQueueNumber++;
        return currentQueueNumber;
    }

    public int getCurrent() {
        return currentQueueNumber;
    }

    public void reset(int newNumber) {
        if (newNumber < 0) {
            System.out.println("Invalid: Number cannot be negative.");
            return;
        }
        currentQueueNumber = newNumber;
        System.out.println("Queue reset to: " + newNumber);
        notifyMonitors();
    }

    public void notifyMonitors() {
        System.out.println("Now serving: " + currentQueueNumber + " [All Monitors Updated]");
    }
}