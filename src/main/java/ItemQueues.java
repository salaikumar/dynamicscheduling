
import javafx.collections.transformation.SortedList;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;

import java.util.*;

/**
 * Item Queues
 * Contains 3 lists for each priority.
 * The HIGHEST is directly passed on to the Async messaging system.
 * A async messaging system reads  it based on the some predefined ratio
 */
public class ItemQueues {
    private List<LineItem> low;
    private List<LineItem> lowest;
    private List<LineItem> high;
    public ItemQueues(){
        low    = new LinkedList<LineItem>();
        lowest = new LinkedList<LineItem>();
        high   = new LinkedList<LineItem>();
    }

    public void add (LineItem lineItem){
        switch (lineItem.getPriority()){
            case HIGHEST:
                Message.send(lineItem);
                break;
            case LOW:
                low.add(lineItem);
                break;
            case LOWEST:
                lowest.add(lineItem);
                break;
            case HIGH:
                high.add(lineItem);
                break;
        }
    }

    /*
     * Returns a list of items to be send to the Async system
     * 10 at a time.
     * no need to worry about the order because it is insertion order
     */
    public List<LineItem> getToSendList(){

        List<LineItem> toSend = new ArrayList<LineItem>();

        int length = high.size();
        if (length !=0) {
            for (int i = 0; i < length / 2; ++i) {
                toSend.add(high.remove(i));
            }
        }

        length = low.size();
        if (length !=0 ) {
            for (int i = 0; i < length / 3; ++i) {
                toSend.add(low.remove(i));
            }
        }

        length = lowest.size();
        if (length !=0 ) {
            for (int i = 0; i < length / 4; ++i) {
                toSend.add(lowest.remove(i));
            }
        }

        return toSend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemQueues that = (ItemQueues) o;

        if (low != null ? !low.equals(that.low) : that.low != null) return false;
        if (lowest != null ? !lowest.equals(that.lowest) : that.lowest != null) return false;
        return high != null ? high.equals(that.high) : that.high == null;

    }

    @Override
    public int hashCode() {
        int result = low != null ? low.hashCode() : 0;
        result = 31 * result + (lowest != null ? lowest.hashCode() : 0);
        result = 31 * result + (high != null ? high.hashCode() : 0);
        return result;
    }
}
