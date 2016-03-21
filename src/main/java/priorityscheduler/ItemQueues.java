package priorityscheduler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Item Queues
 * Contains lists for each priority.
 * The HIGHEST is directly passed on to the Async messaging system.
 */
public class ItemQueues {
    private Queue<LineItem> low;
    private Queue<LineItem> lowest;
    private Queue<LineItem> high;
    private Queue<LineItem> normal;
    public ItemQueues(){
        low    = new LinkedList<LineItem>();
        lowest = new LinkedList<LineItem>();
        high   = new LinkedList<LineItem>();
        normal = new LinkedList<LineItem>();
    }

    public void add (LineItem lineItem){
        switch (lineItem.getPriority()){
            case Priority.HIGHEST:
                Message.send(lineItem);
                break;
            case Priority.LOW:
                low.add(lineItem);
                break;
            case Priority.LOWEST:
                lowest.add(lineItem);
                break;
            case Priority.HIGH:
                high.add(lineItem);
                break;
            case Priority.NORMAL:
                normal.add(lineItem);
                break;
            default:
                normal.add(lineItem);
        }
    }

    public boolean isEmpty(){
        return low.isEmpty() && lowest.isEmpty()
                && normal.isEmpty() && high.isEmpty();
    }
    /*
     * Returns a list of items to be send to the Async system
     * no need to worry about the order because it is insertion order
     */
    public List<LineItem> getToSendList(){
        List<LineItem> toSend = new ArrayList<LineItem>();
        int length = high.size();
        if (length !=0) {
            for (int i = 0; i < length; ++i) {
                toSend.add(high.poll());
            }
        }

        length = normal.size();
        int copyLength = ( length < 2 ) ?  length % 2: length / 2;
        if (copyLength !=0) {
            for (int i = 0; i < copyLength; ++i) {
                toSend.add(normal.poll());
            }
        }

        length = low.size();
        copyLength = ( length < 3 ) ?  length % 3: length / 3;
        if (copyLength !=0 ) {
            for (int i = 0; i < copyLength; ++i) {
                toSend.add(low.poll());
            }
        }

        length = lowest.size();
        copyLength = ( length < 4 ) ?  length % 4: length / 4;
        if (copyLength !=0 ) {
            for (int i = 0; i < copyLength; ++i) {
                toSend.add(lowest.poll());
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
