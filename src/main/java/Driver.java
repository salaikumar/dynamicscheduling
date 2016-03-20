import java.io.IOException;

/**
 * Client Program to execute the Dynamic Scheduling
 */
public class Driver {
    public static void main(String[] args){
        Scheduler scheduler = new Scheduler();
        try {
            scheduler.schedule(args[0]); // "/home/salaikumar/WebApps/Items" -> Your file path
        } catch (IOException e) {
            e.printStackTrace();
        }
        ItemQueues itemQueues = scheduler.getItemQueues();
        while (!itemQueues.isEmpty() ) {
            Message.send(itemQueues.getToSendList());
        }
    }
}


