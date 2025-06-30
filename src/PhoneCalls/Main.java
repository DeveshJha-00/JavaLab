package PhoneCalls;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Contact> contacts = new LinkedList<>();
        List<MissedCall> missedCalls = new ArrayList<>();

        contacts.add(new Contact("name 1", 9980967252L));
        contacts.add(new Contact("name 2", 8756285167L));

        while (true) {
            System.out.println("\nEnter choice - ");
            System.out.println("1.Add missed call\n2.Manage missed calls\n3.Display");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number - ");
                    Long missedCallNumber = sc.nextLong();
                    String name = "Private Caller";
                    for (Contact c : contacts) {
                        Long num = c.number;
                        if (num.equals(missedCallNumber)) {
                            name = c.name;
                            break;
                        }
                    }
                    MissedCall mc = new MissedCall(LocalTime.now(), name, missedCallNumber);
                    if (missedCalls.size() < 5){
                        missedCalls.add(mc);
                    }else{
                        MissedCall rem = missedCalls.remove(0);
                        System.out.println("Removed call : " + rem);
                        missedCalls.add(mc);
                    }
                    break;

                case 2:
                    List<MissedCall> delCallList = new ArrayList<>();
                    for (MissedCall m : missedCalls){
                        System.out.println("Do u want to view details or delete the missed call from " + m.number + " ? ");
                        System.out.println("Enter '0' to view details or '1' to delete");
                        int val = sc.nextInt();
                        if (val==0) {
                            System.out.println("Missed call details - " + m);
                        } else if (val==1) {
                            delCallList.add(m);
                        }
                    }
                    missedCalls.removeAll(delCallList);
                    break;

                case 3:
                    System.out.println("Total contacts : " + contacts.size());
                    System.out.println("Contacts are - " + contacts);
                    System.out.println("Total missed calls : " + missedCalls.size());
                    System.out.println("Missed Calls are - " + missedCalls);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        }
    }
}











