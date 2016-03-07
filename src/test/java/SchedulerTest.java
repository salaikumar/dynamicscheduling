import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UnitTests Scheduler
 */
public class SchedulerTest {

    @Test
    public void shouldTestSchedule(){
        Scheduler sample = new Scheduler();
        try {
            sample.schedule("/home/salaikumar/WebApps/Items");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ItemQueues itemQueues = sample.getItemQueues();
        List<LineItem> toSendList = itemQueues.getToSendList();
        assertThat(toSendList.contains(new LineItem("ITEM1",12345,4,Priority.LOW,"ITEM")),is(true));
    }
}