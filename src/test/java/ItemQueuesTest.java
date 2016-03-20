
import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *
 * ItemQueue unit test
 */
public class ItemQueuesTest {

    @Test
    public  void shouldTestItemQueue(){
        ItemQueues itemQueues = new ItemQueues();
        itemQueues.add(new LineItem("ITEM2",12645,1,Priority.HIGH,"ITEM"));
        itemQueues.add(new LineItem("ITEM3",123456,1,Priority.HIGH,"PRICE"));
        itemQueues.add(new LineItem("ITEM4",123454,1,Priority.HIGH,"ITEM"));
        itemQueues.add(new LineItem("ITEM5",123455,1,Priority.HIGH,"AUX_ITEM"));
        itemQueues.add(new LineItem("ITEM7",123456,1,Priority.HIGH,"PRICE"));
        itemQueues.add(new LineItem("ITEM8",123457,1,Priority.LOW,"AUX_ITEM"));
        itemQueues.add(new LineItem("ITEM9",123458,1,Priority.LOW,"PRICE"));
        itemQueues.add(new LineItem("ITEM10",1234510,1,Priority.LOWEST,"AUX_ITEM"));
        itemQueues.add(new LineItem("ITEM11",1234511,1,Priority.LOWEST,"PRICE"));
        itemQueues.add(new LineItem("ITEM12",1234512,1,Priority.LOWEST,"AUX_ITEM"));
        itemQueues.add(new LineItem("ITEM25",25,25,Priority.HIGHEST,"AUX_ITEM"));

        List<LineItem> toSendList = itemQueues.getToSendList();
        assertThat(toSendList.contains(new LineItem("ITEM25",25,25,Priority.HIGHEST,"AUX_ITEM")),is(false));
        assertThat(toSendList.contains(new LineItem("ITEM11",1234511,1,Priority.LOWEST,"PRICE")),is(true));
        assertThat(toSendList.contains(new LineItem("ITEM2",12645,1,Priority.HIGH,"ITEM")),is(true));

    }
}