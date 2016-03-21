import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UnitTests Scheduler
 */
public class SchedulerTest {

    @Test
    public void shouldTestSchedule() throws IOException {

        Scheduler sample = new Scheduler();

        List<String> lineItems = Files.readAllLines(Paths.get("/home/salaikumar/WebApps/Items"));

        for ( String item : lineItems){
            String[] properties = item.split(",");
            String itemId = properties[0];
            int merchantId = Integer.parseInt(properties[1]);
            int marketPlaceId = Integer.parseInt(properties[2]);
            String data_type = properties[4];
            Priority priority = Priority.NORMAL;
            if (properties[3].equalsIgnoreCase("HIGHEST") )
                priority = Priority.HIGHEST;
            else if (properties[3].equalsIgnoreCase("HIGH"))
                priority = Priority.HIGH;
            else if (properties[3].equalsIgnoreCase("LOW"))
                priority = Priority.LOW;
            else if (properties[3].equalsIgnoreCase("NORMAL"))
                priority = Priority.NORMAL;
            else if (properties[3].equalsIgnoreCase("LOWEST"))
                priority = Priority.LOWEST;

        sample.schedule(new LineItem(itemId,merchantId,marketPlaceId,priority,data_type));

        }

        List<LineItem> toSendList = sample.getItems();
        assertThat(toSendList.contains(new LineItem("ITEM1",12345,4,Priority.LOW,"ITEM")),is(true));
    }
}