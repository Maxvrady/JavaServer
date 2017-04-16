package Time;

import java.util.Timer;
import java.util.TimerTask;

public class HappyTime {

    Timer timer = new Timer();

    public void Time(Long delay) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.print("I rinn");
            }
        }, delay);
    }
}
