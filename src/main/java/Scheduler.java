import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Scheduler
 * Reads the file and puts the data in the priority Queues
 */
public class Scheduler {
    private ItemQueues itemQueues;

    public Scheduler() {
        itemQueues = new ItemQueues();
    }

    /*
     * Schedule one item at a time - Decoupling the file reading part from Scheduler
     */
    public void schedule(LineItem item){
        itemQueues.add(item);
    }

    /*
     * returns the list of items to be sent
     */
    public List<LineItem> getItems(){
        return itemQueues.getToSendList();
    }

    /*
     * returns if the items Queue is empty
     */
    public boolean isQueueEmpty(){
        return itemQueues.isEmpty();
    }
}
