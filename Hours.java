import java.util.*;
import java.time.*;

public class Hours {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter starting hour: ");
        String startHour =  scan.nextLine();
        System.out.println("Please enter starting minute: ");
        String startMinute = scan.nextLine();
        System.out.println("Please enter break duration: ");
        int breakDuration = scan.nextInt();
        
        System.out.printf("\nValues entered:\n\tStarting time: %s:%s\n\tBreak duration: %d\n", startHour, startMinute, breakDuration);
        
        int leaveHour = Integer.parseInt(startHour) + 8;
        int leaveMinute = Integer.parseInt(startMinute) + 30 - (66-breakDuration);
        
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
            System.out.printf("\nOutput:\n\tYou should leave after: %d:%d\n", leaveHour, leaveMinute);
        }

        StringBuilder progress = new StringBuilder();
        
        while (!"#".equals(scan.nextLine())) {
            LocalDateTime currentTime = LocalDateTime.now();
            int hour = currentTime.getHour();
            int minute = currentTime.getMinute();

            int percentageValue = (((hour*60+minute)-(Integer.parseInt(startHour)*60+Integer.parseInt(startMinute)))*100)/(((leaveHour*60) + leaveMinute)-(Integer.parseInt(startHour)*60+Integer.parseInt(startMinute)));
            //System.out.println("\nPercentage complete: " + percentageValue);

            for(int i = 0; i < 100; i++) {

                if(i <= percentageValue) {
                    progress.append('#');
                }
                else {
                    progress.append(' ');
                }
            }
        
            System.out.println("\nProgress:\n[" + progress.toString() + "] (" + percentageValue + "%)\n");
            progress.setLength(0);
        }
        
        scan.close();
    }
    
}
