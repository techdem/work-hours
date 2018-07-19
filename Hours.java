import java.util.*;
import java.time.*;

public class Hours {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter starting hour: ");
        String getTime = scan.nextLine();
        int startHour =  Integer.parseInt(getTime.substring(0,getTime.indexOf(":")));
        int startMinute = Integer.parseInt(getTime.substring(getTime.indexOf(":")+1));
        System.out.println("Please enter break duration (in minutes): ");
        int breakDuration = scan.nextInt();
        
        if(startHour < 10) {
            System.out.printf("\nValues entered:\n\tStarting time: 0%s", startHour);
        }
        else {
            System.out.printf("\nValues entered:\n\tStarting time: %s", startHour);
        }
        
        if(startMinute < 10) {
            System.out.printf(":0%s\n\tBreak duration: %d\n", startMinute, breakDuration);
        }
        else {
            System.out.printf(":%s\n\tBreak duration: %d\n", startMinute, breakDuration);
        }
        
        int leaveHour = startHour + 8;
        int leaveMinute = startMinute + 30 - (66-breakDuration);
        
        if(leaveMinute < 0) {
            leaveHour--;
            leaveMinute+=60;
        }
        
        if(leaveMinute > 59) {
            leaveHour++;
            leaveMinute-=60;
        }
        
        if(leaveMinute < 10) {
            System.out.printf("\nOutput:\n\tYou should leave after: %d:0%d\n", leaveHour, leaveMinute);
        }
        else {
            System.out.printf("\nOutput:\n\tYou should leave after: %d:%d\n\n", leaveHour, leaveMinute);
        }

        StringBuilder progress = new StringBuilder();
        
        while (!"#".equals(scan.nextLine())) {
            LocalDateTime currentTime = LocalDateTime.now();
            int hour = currentTime.getHour();
            int minute = currentTime.getMinute();

            int percentageValue = (((hour*60+minute)-(startHour*60+startMinute))*100)/(((leaveHour*60) + leaveMinute)-(startHour*60+startMinute));

            for(int i = 0; i < 100; i++) {

                if(i < percentageValue) {
                    progress.append('#');
                }
                else {
                    progress.append(' ');
                }
            }
            System.out.println("Progress:\n[" + progress.toString() + "] (" + percentageValue + "%)\n");
            progress.setLength(0);
        }
        scan.close();
    }
}
