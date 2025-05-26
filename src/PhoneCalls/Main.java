package PhoneCalls;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Contact> contacts = new ArrayList<>();
        List<MissedCall> missedCalls = new ArrayList<>();

        contacts.add(new Contact("name 1", 9980967252L));
        contacts.add(new Contact("name 2", 8756285167L));
        System.out.println("Contacts --> " + contacts);

        while (true) {
            System.out.println("Enter choice - ");
            System.out.println("1. Add missed call\n 2.List the missed calls : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number - ");
                    Long missedCallNumber = sc.nextLong();
                    String name = "";
                    for (Contact c : contacts) {
                        Long num = c.number;
                        if (num.equals(missedCallNumber)) {
                            name = c.name;
                            break;
                        }else {
                            name = "Private caller";
                        }
                    }
                    if (missedCalls.size() < 3){
                        missedCalls.add(new MissedCall(LocalTime.now(), name, missedCallNumber));
                    }else{
                        MissedCall rem = missedCalls.remove(0);
                        System.out.println("Removed number : " + rem);
                        missedCalls.add(new MissedCall(LocalTime.now(), name, missedCallNumber));
                    }
                    System.out.println("Missed calls are : " + missedCalls);
                    break;

                case 2:
                    System.out.println("Total missed calls : " + missedCalls.size());
                    System.out.println("Missed Calls are - " + missedCalls);
                    List<MissedCall> delCallList = new ArrayList<>();
                    for (MissedCall m : missedCalls){
                        System.out.println("Do u want to delete the missed call from " + m.number + " ? ");
                        System.out.println("Enter '1' to delete");
                        int val = sc.nextInt();
                        if (val==1) delCallList.add(m);
                    }
                    missedCalls.removeAll(delCallList);
                    System.out.println("Remaining missed calls : " + missedCalls);
                    break;
            }

        }
    }
}











