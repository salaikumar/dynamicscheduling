import java.io.*;
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
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

    public void schedule(String fileLocation) throws IOException {
       List<String> lineItems = Files.readAllLines(Paths.get(fileLocation));

        for ( String item : lineItems){
            String[] properties = item.split(",");
            String itemId = properties[0];
            int merchantId = Integer.parseInt(properties[1]);
            int marketPlaceId = Integer.parseInt(properties[2]);
            String data_type = properties[4];
            Priority priority;
            if (properties[3] == "HIGHEST")
                priority = Priority.HIGHEST;
            else if (properties[3] == "HIGH")
                priority = Priority.HIGH;
            else if (properties[3] == "LOW")
                priority = Priority.LOW;
            else
                priority = Priority.LOWEST;

            itemQueues.add(new LineItem(itemId,merchantId,marketPlaceId,priority,data_type));
        }
    }
}
