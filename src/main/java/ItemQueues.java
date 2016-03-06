
import java.util.LinkedList;
import java.util.List;

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
     */
    public List<LineItem> getToSendList(){
        List<LineItem> toSend = new LinkedList<LineItem>();
        int length = high.size();
        for (int i=0; i< length/2; ++i){
            toSend.add(high.remove(i));
        }
        length = low.size();
        for (int i = 0; i < length/3 ; ++i){
            toSend.add(low.remove(i));
        }
        length = lowest.size();
        for (int i= 0; i < length/4; ++i){
            toSend.add(lowest.remove(i));
        }
        return toSend;
    }

}