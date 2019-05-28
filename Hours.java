import java.util.*;
import java.time.*;

public class Hours {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter start time: ");
        String getTime = scan.nextLine();
        int startHour =  Integer.parseInt(getTime.substring(0,getTime.indexOf(":")));
        int startMinute = Integer.parseInt(getTime.substring(getTime.indexOf(":")+1));

        System.out.println("Please enter break start: ");
        getTime = scan.nextLine();
        int breakStartHour =  Integer.parseInt(getTime.substring(0,getTime.indexOf(":")));
        int breakStartMinute = Integer.parseInt(getTime.substring(getTime.indexOf(":")+1));

        System.out.println("Please enter break end: ");
        getTime = scan.nextLine();
        int breakEndHour =  Integer.parseInt(getTime.substring(0,getTime.indexOf(":")));
        int breakEndMinute = Integer.parseInt(getTime.substring(getTime.indexOf(":")+1));

        int breakDuration = (breakEndHour > breakStartHour) ? 60 * (breakEndHour - (breakStartHour + 1)) + (60 - breakStartMinute) + breakEndMinute : breakEndMinute - breakStartMinute;

        System.out.println("Values entered:\n");

        if(startHour < 10) {
            System.out.printf("\tStarting time : 0%s", startHour);
        }
        else {
            System.out.printf("\tStarting time : %s", startHour);
        }
        
        if(startMinute < 10) {
            System.out.printf(":0%s\n", startMinute);
        }
        else {
            System.out.printf(":%s\n", startMinute);
        }

        if(breakStartHour < 10) {
            System.out.printf("\tBreak start   : 0%s", breakStartHour);
        }
        else {
            System.out.printf("\tBreak start   : %s", breakStartHour);
        }

        if(breakStartMinute < 10) {
            System.out.printf(":0%s\n", breakStartMinute);
        }
        else {
            System.out.printf(":%s\n", breakStartMinute);
        }

        if(breakEndHour < 10) {
            System.out.printf("\tBreak end     : 0%s", breakEndHour);
        }
        else {
            System.out.printf("\tBreak end     : %s", breakEndHour);
        }

        if(breakEndMinute < 10) {
            System.out.printf(":0%s\n", breakEndMinute);
        }
        else {
            System.out.printf(":%s\n", breakEndMinute);
        }

        if(breakDuration > 29) {
            System.out.printf("\tBreak duration: %d minutes\n", breakDuration);
        }
        else {
            System.out.printf("\tBreak duration: %d minutes (minimum 30)\n", breakDuration = 30);
        }
        
        int leaveHour = startHour + 8;
        int leaveMinute = startMinute + (breakDuration-30);
        
        if(leaveMinute < 0) {
            leaveHour--;
            leaveMinute+=60;
        }
        
        if(leaveMinute > 59) {
            leaveHour++;
            leaveMinute-=60;
        }
        
        if(leaveMinute < 10) {
            System.out.printf("\nYou should leave after: %d:0%d\n", leaveHour, leaveMinute);
        }
        else {
            System.out.printf("\nYou should leave after: %d:%d\n\n", leaveHour, leaveMinute);
        }

        StringBuilder progress = new StringBuilder();
        
        do {
            LocalDateTime currentTime = LocalDateTime.now();
            int hour = currentTime.getHour();
            int minute = currentTime.getMinute();

            int percentageValue = (((hour * 60 + minute) - (startHour * 60 + startMinute)) * 100) / (((leaveHour * 60) + leaveMinute) - (startHour * 60 + startMinute));

            for(int i = 0; i < 100; i++) {

                if(i < percentageValue) {
                    progress.append('#');
                }
                else {
                    progress.append(' ');
                }
            }
            System.out.println("Progress:\n[" + progress.toString() + "] (" + percentageValue + "%)");
            progress.setLength(0);
        } while (!"#".equals(scan.nextLine()));
        scan.close();
    }
}
