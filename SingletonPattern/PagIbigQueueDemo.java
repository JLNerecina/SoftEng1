// PagIbigQueueDemo.java
public class PagIbigQueueDemo {
    public static void main(String[] args) {
        QueueSystem queue = QueueSystem.getInstance();

        // Visitor 1
        int q1 = queue.issueNextNumber();
        System.out.println("Visitor gets: " + q1);
        queue.notifyMonitors();

        // Visitor 2
        int q2 = queue.issueNextNumber();
        System.out.println("Visitor gets: " + q2);
        queue.notifyMonitors();

        // Station serves
        HelpDeskStation s1 = new HelpDeskStation("STATION-1");
        s1.serve();

        // Reset by station
        HelpDeskStation s3 = new HelpDeskStation("STATION-3");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        s3.reset(sc);  // Type: 100

        // Visitor after reset
        int q3 = queue.issueNextNumber();
        System.out.println("Visitor gets: " + q3);
        queue.notifyMonitors();

        sc.close();
    }
}