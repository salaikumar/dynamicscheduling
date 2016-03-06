import javax.sound.sampled.Line;
import java.util.List;


public class Message {

    /*
     * Sends the message to the downstream server
     * Just printing it by now
     */
    public void send(List<LineItem> message){
        for (LineItem item: message){
            send(item);
        }
    }

    public void send(LineItem message){
        System.out.println( message.toString());
    }
}
