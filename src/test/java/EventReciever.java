import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;

public class EventReciever {
    private final ArrayList<Object> events;

    public EventReciever() {
        this.events = new ArrayList<>();
    }

    public boolean receivedEventOfClass(Class eventClass){
        for(Object o : events){
            if(o.getClass() == eventClass){
                return true;
            }
        }

        return false;
    }

    @Subscribe
    public void receive(Object o){
        events.add(o);
    }
}
