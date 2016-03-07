import org.junit.Test;
import org.junit.experimental.theories.Theories;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * UnitTests Scheduler
 */
public class SchedulerTest {

    @Test
    public void shouldTestSchedule(){
        Scheduler sample = new Scheduler();
        try {
            sample.schedule("\"/home/salaikumar/WebApps/Items\"");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ItemQueues itemQueues = sample.getItemQueues();
//        assertThat(itemQueues.);
    }
}