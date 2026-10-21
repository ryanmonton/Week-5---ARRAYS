import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public class ClassStatisticsCalculator {
    public static void main(String[] args) {
        
        // int array wit 8 student scores
        int[] scores = {85, 93, 78, 91, 88, 98, 95, 87};
        
        // Calculate sum using loop
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        
        // Calculate average
        double average = (double) sum / scores.length;
        
        // Find highest score using loop
        int highest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }
        
        // Find lowest score using loop
        int lowest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }
        
        // Print all statistics
        System.out.println("=== Class Statistics ===");
        System.out.println("Total Sum: " + sum);
        System.out.printf("Average Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
    }
}
/*
Programmer's Name: Ryan A. Monton
Course & Year: DIT 2-7
*/
}
