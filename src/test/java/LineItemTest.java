

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit Test LineItem
 */
public class LineItemTest {

    @Test
    public void shouldTestLineItem(){
        LineItem lineItem = new LineItem("ITEM1",12345, 4,Priority.LOW,"ITEM");
        assertThat(lineItem.getDataType(),is("ITEM"));
    }
}