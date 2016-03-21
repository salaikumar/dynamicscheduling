package priorityscheduler;

import org.junit.Test;
import priorityscheduler.LineItem;
import priorityscheduler.Priority;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit Test priorityscheduler.LineItem
 */
public class LineItemTest {

    @Test
    public void shouldTestLineItem(){
        LineItem lineItem = new LineItem("ITEM1",12345, 4, Priority.LOW,"ITEM");
        assertThat(lineItem.getDataType(),is("ITEM"));
    }
}