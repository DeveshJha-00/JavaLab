package PhoneCalls;

import java.time.LocalTime;

public class MissedCall {
    LocalTime lt;
    String name;
    long number;

    public MissedCall(LocalTime lt, String name, long number) {
        this.lt = lt;
        this.name = name;
        this.number = number;
    }

    public String toString(){
        return lt + " " + name + " " + number;
    }
}
